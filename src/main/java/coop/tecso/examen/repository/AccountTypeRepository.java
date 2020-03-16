package coop.tecso.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import coop.tecso.examen.model.AccountType;

public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {

}