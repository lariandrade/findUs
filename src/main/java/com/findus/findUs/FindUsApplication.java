package com.findus.findUs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages="com.findus.findUs.models")
@ComponentScan(basePackages = {"com.*"})
@EnableJpaRepositories(basePackages = {"com.findus.findUs.repository"})
@EnableTransactionManagement
public class FindUsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindUsApplication.class, args);
	}

}
