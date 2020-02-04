package com.cavetech.springboot.Accountcredt.app.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.cavetech.springboot.Accountcredt.app.domain.AccountCredit;
import com.cavetech.springboot.Accountcredt.app.domain.Client;
import com.cavetech.springboot.Accountcredt.app.domain.ProductCredit;
import com.cavetech.springboot.Accountcredt.app.repository.AccountCreditRepository;
import com.cavetech.springboot.Accountcredt.app.service.AccountCreditService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountCreditServiceImpl implements AccountCreditService {

	@Autowired
	AccountCreditRepository acccreditkrep;

	// registro de cuentas bancarias 
	@Override
	public Mono<AccountCredit> save(AccountCredit accountCredit) {
		return WebClient.builder().baseUrl("http://localhost:8009/client/client/").build().get()
				.uri(accountCredit.getClient().getId()).retrieve().bodyToMono(Client.class).log()
				.flatMap(cl -> {
					accountCredit.setClient(cl);
		return WebClient.builder().baseUrl("http://localhost:8009/productcredito/productcredt/").build().get()
							.uri(accountCredit.getProduct().getId()).retrieve().bodyToMono(ProductCredit.class).log();
				})

				.flatMap(acc -> {
				accountCredit.setProduct(acc);
					accountCredit.setInteres(accountCredit.getProduct().getInteres());
					System.out.println("interes");
					System.out.println(accountCredit.getProduct().getInteres());
					return acccreditkrep.save(accountCredit);
				});
		
	}

	@Override
	public Flux<AccountCredit> findAll() {
		return this.acccreditkrep.findAll();
	}

	@Override
	public Mono<AccountCredit> findById(String id) {
		return this.acccreditkrep.findById(id);
	}

	@Override
	public Mono<Void> deletexId(String id) {
		return this.acccreditkrep.deleteById(id);
	}

	@Override
	public Mono<Void> delete(AccountCredit accountCredit) {
		return this.acccreditkrep.delete(accountCredit);
	}

	/*
	 * @Override public Flux<AccountBank> findxClient(String idClient) { return
	 * WebClient.builder().baseUrl("http://localhost:8099/micro-clientes/clientes/")
	 * .build().get()
	 * .uri(idClient).retrieve().bodyToMono(Client.class).log().flatMapMany(cli -> {
	 * return accbankrep.findxClient(cli); }); return null; }
	 */

}
