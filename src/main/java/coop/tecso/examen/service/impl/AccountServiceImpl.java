package coop.tecso.examen.service.impl;

import java.math.BigDecimal;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.dto.AccountDto;
import coop.tecso.examen.dto.AccountTypeDto;
import coop.tecso.examen.model.Account;
import coop.tecso.examen.repository.AccountRepository;
import coop.tecso.examen.service.AccountService;
import coop.tecso.examen.service.MathService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public Integer createNumberAccount() {
		Integer numberAccount = null;
		Boolean exists = true;
		while(exists) {
			numberAccount = new Random().nextInt(999999);
			Account account = accountRepository.findByAccountNumber(numberAccount);
			if(account == null ) {
				exists = false;
			}
		}
		
		return numberAccount;
	}

	@Override
	public Boolean validateParametersForSave(AccountTypeDto accountTypeDto) {
		return accountTypeDto.getId() != null;
	}

	@Override
	public Boolean validateParametersForDelete(AccountDto accountDto) {
		return accountDto.getId() != null;
	}


}
