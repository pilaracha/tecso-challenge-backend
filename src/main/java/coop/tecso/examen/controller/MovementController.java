package coop.tecso.examen.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.dto.AccountDto;
import coop.tecso.examen.dto.AccountTypeDto;
import coop.tecso.examen.dto.MovementDto;
import coop.tecso.examen.model.Account;
import coop.tecso.examen.model.AccountType;
import coop.tecso.examen.model.Movement;
import coop.tecso.examen.repository.AccountRepository;
import coop.tecso.examen.repository.MovementRepository;
import coop.tecso.examen.service.MovementService;

@RestController
@CrossOrigin("*")
@RequestMapping("/movement")
public class MovementController {

	@Autowired
	private MovementRepository movementRepository;
	
	@Autowired
	private MovementService movementService;
	
	@Autowired
	private AccountRepository accountRepository;
	

	@GetMapping("/findAllByAccount/{accountId}")
	public ResponseEntity findAll(@PathVariable String accountId) {
		List<MovementDto> result = new ArrayList<>();
		Optional<Account> account = accountRepository.findById(Long.parseLong(accountId));
		if(account.isPresent()){
			for (Movement entity : movementRepository.findByAccountOrderByMovementDateDesc(account.get())) {
				MovementDto dto = entity.convertToDto(entity);
				result.add(dto);
			}
			return new ResponseEntity<List<MovementDto>>(result,HttpStatus.OK);
		}else{
			return new ResponseEntity<String>("The account does not exists",HttpStatus.OK);
		}
		
		
	}
	
	@PostMapping("/save")
	public ResponseEntity save(@RequestBody MovementDto movementRequest) {
		
		if(movementService.validateParametersForSave(movementRequest)) {
			Optional<Account> account = accountRepository.findById(movementRequest.getAccount().getId());
			
			if (account.isPresent()){
			    Account accountEntity = account.get();
			    if(movementRequest.getMovementAmount() <= accountEntity.getAccountType().getAccountTypeDiscovered()){
			    	if(movementRequest.getMovementType().equals("Debit")) {
			    		if(movementRequest.getMovementAmount() <= accountEntity.getAccountBalance()) {
			    			accountEntity.setAccountBalance(accountEntity.getAccountBalance() - movementRequest.getMovementAmount());
			    		}else{
			    			return new ResponseEntity<String>("The movement could not be added since it does not have enough balance",HttpStatus.CONFLICT);
			    		}   	
				    }
				    Movement newMovement = new Movement(accountEntity, movementRequest.getMovementType(), new Date() ,movementRequest.getMovementDescription(),
				    		movementRequest.getMovementAmount());
				    movementRepository.save(newMovement);
				    
				    return new ResponseEntity<MovementDto>(movementRequest,HttpStatus.OK);
			    }else {
			    	return new ResponseEntity<String>("The movement could not be added since it exceeds the maximum amount",HttpStatus.CONFLICT);
			    }
			    
			}
			else{
				return new ResponseEntity<String>("Unable to add a move to a non-existent account",HttpStatus.NOT_FOUND);
			}
		}else {
			return new ResponseEntity<String>("To add a new movement you must enter all the data",HttpStatus.NOT_FOUND);
		}
		
	}
	
}
