package com.cavetech.springboot.Accountcredt.app.service.Impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavetech.springboot.Accountcredt.app.domain.Transactions;
import com.cavetech.springboot.Accountcredt.app.dto.OperationDto;
import com.cavetech.springboot.Accountcredt.app.repository.AccountCreditRepository;
import com.cavetech.springboot.Accountcredt.app.repository.TransactionRepository;
import com.cavetech.springboot.Accountcredt.app.service.OperationService;

import reactor.core.publisher.Mono;

@Service
public class OperationServiceImpl implements OperationService {

	@Autowired
	AccountCreditRepository accrepo;
	@Autowired
	TransactionRepository tranrepo;

	@Override
	public Mono<Transactions> cons(OperationDto dto) {
		System.out.println("2 - Consumo");
		
		return accrepo.findByNumcount(dto.getAccountOrig()).flatMap(account -> {
			
			if((account.getLineCredit()-account.getBalance()) >=dto.getAmount()) {
				account.setBalance(account.getBalance() - dto.getAmount());
				return accrepo.save(account);	
				
			}

			return Mono.error(new InterruptedException(" no cuenta con saldo suficiente para el consumo"));
			
		}).flatMap(account -> {

			Transactions tran = new Transactions(dto.getAccountOrig(), account.getNumcount(), "Consumo ", new Date(),
					dto.getAmount());
		
			return tranrepo.save(tran);
		});
	}

	@Override
	public Mono<Transactions> pay(OperationDto dto)   {
		
		System.out.println("1 - pago");
		return accrepo.findByNumcount(dto.getAccountDest()).flatMap(account -> {
			if(account!=null) {
			if((account.getLineCredit()-account.getBalance()) < dto.getAmount()) {
				return Mono.error(new InterruptedException(" monto de abono mayor al limite de tarjeta"));
			}	
			account.setBalance(account.getBalance() + dto.getAmount());
			return accrepo.save(account);			
			}		
		else {
			return Mono.error(new InterruptedException(" no se ha encontrado la cuenta"));
		}
		}).flatMap(account -> {

			Transactions tran = new Transactions(dto.getAccountOrig(), account.getNumcount(), "Abono ", new Date(),
					dto.getAmount());
		
			return tranrepo.save(tran); 
		});

	}

}
