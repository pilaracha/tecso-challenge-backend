package coop.tecso.examen.model;

import javax.persistence.Entity;

import org.modelmapper.ModelMapper;

import coop.tecso.examen.dto.AccountDto;
import coop.tecso.examen.dto.AccountTypeDto;

@Entity
public class AccountType extends AbstractPersistentObject {

	private static final long serialVersionUID = -8901155893511467206L;
	

	private String accountTypeCurrency;
	private String accountTypeDescription;
	private Double accountTypeDiscovered;
	
	
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
	public Double getAccountTypeDiscovered() {
		return accountTypeDiscovered;
	}
	public void setAccountTypeDiscovered(Double accountTypeDiscovered) {
		this.accountTypeDiscovered = accountTypeDiscovered;
	}
	
	public AccountTypeDto convertToDto(AccountType entity) {
		ModelMapper modelMapper = new ModelMapper();
		AccountTypeDto dto = modelMapper.map(entity, AccountTypeDto.class);
		
		return dto;

	}
	
	
}