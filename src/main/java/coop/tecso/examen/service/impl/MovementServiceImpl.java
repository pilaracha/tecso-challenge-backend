package coop.tecso.examen.service.impl;

import java.math.BigDecimal;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.dto.MovementDto;
import coop.tecso.examen.service.MovementService;



@Service
public class MovementServiceImpl implements MovementService {


	@Override
	public Boolean validateParametersForSave(MovementDto movementDto) {
		return  movementDto.getAccount() != null &&
				movementDto.getMovementAmount() != null &&
				movementDto.getMovementDescription() != null &&
				movementDto.getMovementType() != null;
	}


	

}
