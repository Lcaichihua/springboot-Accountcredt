package com.cavetech.springboot.Accountcredt.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReportBalance {

	private String  idAccount ;
	private Double saldo;

	
	
}
