package coop.tecso.examen.model;

import java.text.DecimalFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.modelmapper.ModelMapper;

import coop.tecso.examen.dto.AccountDto;
import coop.tecso.examen.dto.AccountTypeDto;

@Entity
public class Account extends AbstractPersistentObject {

	private static final long serialVersionUID = -8901155893511467206L;
	
	@ManyToOne(optional = false, cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private AccountType accountType;
	private Integer accountNumber;
	private Double accountBalance;
	
	public Account() {
		super();
	}

	
	public Account(AccountType accountType, Integer accountNumber, Double accountBalance) {
		super();
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}


	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public Integer getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public AccountDto convertToDto(Account entity) {
		ModelMapper modelMapper = new ModelMapper();
		AccountDto dto = modelMapper.map(entity, AccountDto.class);
		
		DecimalFormat df2 = new DecimalFormat("0.00");
		dto.setAccountBalance(df2.format(entity.getAccountBalance()));
		return dto;
	}
	
	
}
