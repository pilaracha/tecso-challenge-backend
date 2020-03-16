package coop.tecso.examen.dto;

import java.io.Serializable;

import org.modelmapper.ModelMapper;

import coop.tecso.examen.model.AccountType;

public class AccountTypeDto implements Serializable {
	

	private static final long serialVersionUID = -1854383574061855612L;

	private Long id;
	private String accountTypeCurrency;
	private String accountTypeDescription;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getAccountTypeCurrency() {
		return accountTypeCurrency;
	}
	
	public void setAccountTypeCurrency(String accountTypeCurrency) {
		this.accountTypeCurrency = accountTypeCurrency;
	}
	
	public String getAccountTypeDescription() {
		return accountTypeDescription;
	}
	
	public void setAccountTypeDescription(String accountTypeDescription) {
		this.accountTypeDescription = accountTypeDescription;
	}	

}
