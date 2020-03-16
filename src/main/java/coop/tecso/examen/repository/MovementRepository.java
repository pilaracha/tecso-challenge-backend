package coop.tecso.examen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import coop.tecso.examen.model.Account;
import coop.tecso.examen.model.Movement;

public interface MovementRepository extends JpaRepository<Movement, Long> {

	List<Movement> findByAccountOrderByMovementDateDesc(Account a);
}