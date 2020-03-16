package coop.tecso.examen.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.dto.AccountDto;
import coop.tecso.examen.dto.AccountTypeDto;
import coop.tecso.examen.model.Account;
import coop.tecso.examen.model.AccountType;
import coop.tecso.examen.model.Movement;
import coop.tecso.examen.repository.AccountRepository;
import coop.tecso.examen.repository.AccountTypeRepository;
import coop.tecso.examen.repository.MovementRepository;
import coop.tecso.examen.service.AccountService;

@RestController
@CrossOrigin("*")
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountTypeRepository accountTypeRepository;
	
	@Autowired
	private MovementRepository movementRepository;
	
	// Get All Countries
	@GetMapping("/findAll")
	public ResponseEntity findAll() {
		
		List<AccountDto> result = new ArrayList<>();
		for (Account entity : accountRepository.findAll()) {
			AccountDto dto = entity.convertToDto(entity);
			result.add(dto);
		}
		
		return new ResponseEntity<List<AccountDto>>(result,HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity findById(@PathVariable String id) {
		
		Optional<Account> account = accountRepository.findById(Long.parseLong(id));
		
		if (account.isPresent()){
			
			Account entity = account.get();
			AccountDto dto = entity.convertToDto(entity);
			
			return new ResponseEntity<AccountDto>(dto,HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("The account does not exist",HttpStatus.NOT_FOUND);
		}

	}
	
	@PostMapping("/save")
	public ResponseEntity saveAccount(@RequestBody AccountTypeDto accountTypeRequest) {
		if(accountService.validateParametersForSave(accountTypeRequest)) {
			Optional<AccountType> accountType = accountTypeRepository.findById(accountTypeRequest.getId());
			
			if (accountType.isPresent()){
			    AccountType typeAccount = accountType.get();
			    Account newAccount = new Account(typeAccount, accountService.createNumberAccount(), 0.00);
			    accountRepository.save(newAccount);
			    
			    
			    return new ResponseEntity<AccountDto>(newAccount.convertToDto(newAccount),HttpStatus.OK);
			}
			else{
				return new ResponseEntity<String>("Account could not be saved",HttpStatus.NOT_FOUND);
			}
		}else{
			return new ResponseEntity<String>("To add a new account you must enter the type",HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@PostMapping("/delete")
	public ResponseEntity deleteAccount(@RequestBody AccountDto accountRequest) {
		
		if(accountService.validateParametersForDelete(accountRequest)) {
			Optional<Account> account = accountRepository.findById(accountRequest.getId());
			
			if (account.isPresent()){
			    Account a = account.get();
			    List<Movement> movements = movementRepository.findByAccountOrderByMovementDateDesc(a);
			    if(movements.isEmpty()) {
			    	accountRepository.deleteById(a.getId());   
				    return new ResponseEntity<AccountDto>(accountRequest,HttpStatus.OK);
			    }else{
			    	return new ResponseEntity<String>("The account cannot be deleted since it has associated movements", HttpStatus.METHOD_NOT_ALLOWED);
			    }
			    
			}
			else{
				return new ResponseEntity<String>("The account cannot be deleted since it does not exist",HttpStatus.NOT_FOUND);
			}
			
		}else {
			return new ResponseEntity<String>("To delete an account you must choose one",HttpStatus.NOT_FOUND);
		}
		
		
	}
		
	
}
