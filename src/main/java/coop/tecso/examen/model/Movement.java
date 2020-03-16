package coop.tecso.examen.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.modelmapper.ModelMapper;

import coop.tecso.examen.dto.MovementDto;

@Entity
public class Movement extends AbstractPersistentObject {

	private static final long serialVersionUID = -8901155893511467206L;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Account account;
	private String movementType;
	private Date movementDate;
	private String movementDescription;
	private Double movementAmount;
		
	
	public Movement() {
		super();
	}
	
	public Movement(Account account, String movementType, Date movementDate, String movementDescription,
			Double movementAmount) {
		super();
		this.account = account;
		this.movementType = movementType;
		this.movementDate = movementDate;
		this.movementDescription = movementDescription;
		this.movementAmount = movementAmount;
	}

	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getMovementType() {
		return movementType;
	}
	public void setMovementType(String movementType) {
		this.movementType = movementType;
	}
	public Date getMovementDate() {
		return movementDate;
	}
	public void setMovementDate(Date movementDate) {
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
	public MovementDto convertToDto(Movement entity) {
		ModelMapper modelMapper = new ModelMapper();
		MovementDto dto = modelMapper.map(entity, MovementDto.class);
		
		//UTC date
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		sdf.setTimeZone( TimeZone.getTimeZone( "UTC" ) );
		dto.setMovementDate( sdf.format( entity.getMovementDate() ) );
		return dto;
	}
	
}