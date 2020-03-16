package coop.tecso.examen.service;

import coop.tecso.examen.dto.AccountDto;
import coop.tecso.examen.dto.AccountTypeDto;

public interface AccountService {
	public Integer createNumberAccount();
	public Boolean validateParametersForSave(AccountTypeDto accountTypeDto);
	public Boolean validateParametersForDelete(AccountDto accountDto);
}
