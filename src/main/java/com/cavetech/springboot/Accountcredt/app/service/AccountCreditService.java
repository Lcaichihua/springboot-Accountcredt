package com.cavetech.springboot.Accountcredt.app.service;





import com.cavetech.springboot.Accountcredt.app.domain.AccountCredit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface AccountCreditService {

	
	//Flux<AccountBank> findxClient(String idClient);
	Mono<AccountCredit> save(AccountCredit accountCredit);

	Flux<AccountCredit> findAll();

	Mono<AccountCredit> findById(String id);

	Mono<Void> deletexId(String id);

	Mono<Void> delete(AccountCredit accountCredit);
}
