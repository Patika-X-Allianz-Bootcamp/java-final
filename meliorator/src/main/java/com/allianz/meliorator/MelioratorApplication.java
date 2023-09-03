package com.allianz.meliorator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MelioratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MelioratorApplication.class, args);
	}

}
