package com.cavetech.springboot.Accountcredt.app.domain;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class TypeProductCredit {
	
	private String id;
	private String description;
	public TypeProductCredit(String description) {
		super();
		this.description = description;
	}
}
