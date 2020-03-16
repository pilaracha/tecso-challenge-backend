package coop.tecso.examen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.dto.AccountTypeDto;
import coop.tecso.examen.model.AccountType;
import coop.tecso.examen.repository.AccountTypeRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/accountType")
public class AccountTypeController {

	@Autowired
	private AccountTypeRepository AccountTypeRepository;
	
	// Get All Countries
	@GetMapping("/findAll")
	public List<AccountTypeDto> findAll() {
		
		List<AccountTypeDto> result = new ArrayList<>();
		for (AccountType entity : AccountTypeRepository.findAll()) {
			AccountTypeDto dto = entity.convertToDto(entity);
			result.add(dto);
		}
		
	    return result;
	}
	
}
