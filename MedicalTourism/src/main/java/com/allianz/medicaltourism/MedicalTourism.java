package com.allianz.medicaltourism;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MedicalTourism {

	public static void main(String[] args) {
		SpringApplication.run(MedicalTourism.class, args);
	}
}
