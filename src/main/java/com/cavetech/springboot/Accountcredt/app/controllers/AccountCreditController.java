package com.cavetech.springboot.Accountcredt.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.cavetech.springboot.Accountcredt.app.domain.AccountCredit;
import com.cavetech.springboot.Accountcredt.app.dto.ReportBalance;
import com.cavetech.springboot.Accountcredt.app.service.AccountCreditService;

import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/accountcredit")
public class AccountCreditController {

	
	@Autowired
	private AccountCreditService AccountCreditServ;
	
	/*@GetMapping("/{idCliente}")
	public Flux<AccountBank> FindProducxClient(@PathVariable String idClient) {
		return AccountBankServ.findxClient(idClient);
	}*/
	
	@PostMapping
	public Mono<AccountCredit> saveAccountCredit(@RequestBody @Valid AccountCredit accountCredit) {
		return AccountCreditServ.save(accountCredit);
	}
	
	@GetMapping("/{idproduct}")
	public Mono<AccountCredit> findbyId(@PathVariable String idproduct) {
		return AccountCreditServ.findById(idproduct);
	}
	
	@GetMapping("/list")
	public Flux<AccountCredit> ListCountBank() {
		return AccountCreditServ.findAll();
	}
	
	@GetMapping("/reporte/{idCliente}")
	@ApiOperation(value = "List balanace for client", notes="Generate balance by id Cliente ")
	public Flux<ReportBalance> reporteProductosSaldo(@PathVariable String idClient) {
		return AccountCreditServ.reportSaldo(idClient);
	}
	
}
