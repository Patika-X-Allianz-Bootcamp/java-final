package com.patika.healthtourism;

import com.patika.healthtourism.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
public class HealthTourismApplication {

	@Autowired
	RoleService roleService;

	public static void main(String[] args) {
		SpringApplication.run(HealthTourismApplication.class, args);
	}


}
