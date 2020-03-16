package coop.tecso.examen.dto;

import java.io.Serializable;

public class AccountDto implements Serializable {
	

	private static final long serialVersionUID = -1854383574061855612L;

	private Long id;
	private AccountTypeDto accountType;
	private Integer accountNumber;
	private String accountBalance;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public AccountTypeDto getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountTypeDto accountType) {
		this.accountType = accountType;
	}
	public Integer getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}
	

}
