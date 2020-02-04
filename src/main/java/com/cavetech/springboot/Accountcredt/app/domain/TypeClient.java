package com.cavetech.springboot.Accountcredt.app.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

public @Data class TypeClient {


	private String id ;
	private String nombre ;
	private Integer valtip ;
	public TypeClient(String nombre, Integer valtip) {
		super();
		this.nombre = nombre;
		this.valtip = valtip;
	}
	
	
	
}