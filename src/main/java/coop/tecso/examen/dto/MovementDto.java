package coop.tecso.examen.dto;

import java.io.Serializable;
import java.util.Date;

import coop.tecso.examen.dto.AccountDto;


public class MovementDto implements Serializable {
	

	private static final long serialVersionUID = -1854383574061855612L;

	private AccountDto account;
	private String movementType;
	private String movementDate;
	private String movementDescription;
	private Double movementAmount;
		
	
	public AccountDto getAccount() {
		return account;
	}
	public void setAccount(AccountDto account) {
		this.account = account;
	}
	public String getMovementType() {
		return movementType;
	}
	public void setMovementType(String movementType) {
		this.movementType = movementType;
	}
	public String getMovementDate() {
		return movementDate;
	}
	public void setMovementDate(String movementDate) {
		this.movementDate = movementDate;
	}
	public String getMovementDescription() {
		return movementDescription;
	}
	public void setMovementDescription(String movementDescription) {
		this.movementDescription = movementDescription;
	}
	public Double getMovementAmount() {
		return movementAmount;
	}
	public void setMovementAmount(Double movementAmount) {
		this.movementAmount = movementAmount;
	}
}
