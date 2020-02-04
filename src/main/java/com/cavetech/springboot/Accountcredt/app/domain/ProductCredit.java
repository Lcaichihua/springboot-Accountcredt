package com.cavetech.springboot.Accountcredt.app.domain;



import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class ProductCredit {

	private String id;
	private String description;
	private double interes;
	private TypeProductCredit typeProductCredit;
	private Integer codigo;
	public ProductCredit(String description, double interes, TypeProductCredit typeProductCredit, Integer codigo) {
		super();
		this.description = description;
		this.interes = interes;
		this.typeProductCredit = typeProductCredit;
		this.codigo = codigo;
	}
	
	
	
	
	
}
