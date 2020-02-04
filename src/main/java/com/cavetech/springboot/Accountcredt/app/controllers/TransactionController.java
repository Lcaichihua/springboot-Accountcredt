package com.cavetech.springboot.Accountcredt.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cavetech.springboot.Accountcredt.app.domain.Transactions;
import com.cavetech.springboot.Accountcredt.app.dto.OperationDto;
import com.cavetech.springboot.Accountcredt.app.service.OperationService;

import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	OperationService operation ;
	
	
	@ApiOperation(value = "consume a account", notes="increment to balance")
	@PostMapping(value = "/consume")
	public Mono<Transactions> consume(@RequestBody @Valid OperationDto dto){
		
		return operation.cons(dto);
	}
	
	@ApiOperation(value = "abono a transaction", notes="Discount from balance")
	@PostMapping(value = "/pay")
	public Mono<Transactions> pay(@RequestBody @Valid OperationDto dto){
		
		return operation.pay(dto);
	}

}
