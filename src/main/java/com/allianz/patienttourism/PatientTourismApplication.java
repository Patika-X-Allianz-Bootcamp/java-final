package com.allianz.patienttourism;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class PatientTourismApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientTourismApplication.class, args);
	}

}
