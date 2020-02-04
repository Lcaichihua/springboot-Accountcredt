package com.cavetech.springboot.Accountcredt.app.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.cavetech.springboot.Accountcredt.app.domain.Client;
import com.cavetech.springboot.Accountcredt.app.domain.ProductCredit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
 
public @Data class OperationDto {
	
	
	@NotEmpty(message = "El numero de cuenta origen no puede ser nulo o estar en blanco")
	private String accountOrig;
	
	private String accountDest;

	private String cci;
	
	@NotNull
	private double amount;
	

}
