package com.cavetech.springboot.Accountcredt.app.service;



import com.cavetech.springboot.Accountcredt.app.domain.Transactions;
import com.cavetech.springboot.Accountcredt.app.dto.OperationDto;

import reactor.core.publisher.Mono;

public interface OperationService {

	public Mono<Transactions> cons (OperationDto dto);
	public Mono<Transactions> pay (OperationDto dto);
}
