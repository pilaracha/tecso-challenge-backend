package coop.tecso.examen;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import coop.tecso.examen.model.Country;
import coop.tecso.examen.repository.CountryRepository;

@SpringBootApplication
public class MainApplication {

	public static void main(final String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}
