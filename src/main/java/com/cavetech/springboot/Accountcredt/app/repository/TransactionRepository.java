package com.cavetech.springboot.Accountcredt.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.cavetech.springboot.Accountcredt.app.domain.AccountCredit;
import com.cavetech.springboot.Accountcredt.app.domain.Transactions;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public interface TransactionRepository   extends ReactiveMongoRepository<Transactions, String>{
	
	//public Flux<Transactions> findByNumcount( String numcount);
	
}
