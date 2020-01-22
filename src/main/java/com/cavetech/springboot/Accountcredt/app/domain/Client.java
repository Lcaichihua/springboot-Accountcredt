package com.cavetech.springboot.Accountcredt.app.domain;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public  @Data   class Client {
	

	private String id;
	private String dni;
	private String firstName ;
	private String lastName;
	private boolean state ;
	private TypeClient type;
	public Client(String dni, String firstName, String lastName, boolean state, TypeClient type) {
		super();
		this.dni = dni;
		this.firstName = firstName;
		this.lastName = lastName;
		this.state = state;
		this.type = type;
	}
	
	
}
