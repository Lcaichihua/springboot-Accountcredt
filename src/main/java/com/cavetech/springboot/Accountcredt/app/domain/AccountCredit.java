package com.cavetech.springboot.Accountcredt.app.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "accountcredit")
public  @Data class AccountCredit {
	
@Id
private String id;
//private String numcount = String.valueOf(Math.floor(Math.random()*99999999+1));
private String numcount = "123456789";
private Client client;
private ProductCredit product ;
private double LineCredit;
private double interes;
private double balance;
private boolean state;
public AccountCredit(Client client, ProductCredit product, Double lineCredit, Double interes, double balance,
		boolean state) {
	super();
	this.client = client;
	this.product = product;
	LineCredit = lineCredit;
	this.interes = interes;
	this.balance = balance;
	this.state = state;
}








}
