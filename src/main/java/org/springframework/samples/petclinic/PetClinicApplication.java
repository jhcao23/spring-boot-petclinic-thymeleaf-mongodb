package org.springframework.samples.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories(basePackages="org.springframework.samples.petclinic.repository.springdatajpa")
@EntityScan(basePackages="org.springframework.samples.petclinic.model.jpa")
@EnableMongoRepositories(basePackages="org.springframework.samples.petclinic.repository.springdatamongodb")
public class PetClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetClinicApplication.class, args);

	}

}
