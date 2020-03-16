package coop.tecso.examen.service;

import coop.tecso.examen.dto.MovementDto;

public interface MovementService {
	public Boolean validateParametersForSave(MovementDto movementDto);

}
