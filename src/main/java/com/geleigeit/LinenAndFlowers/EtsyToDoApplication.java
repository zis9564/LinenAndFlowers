package com.geleigeit.LinenAndFlowers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.geleigeit.LinenAndFlowers.entity")
@EnableJpaRepositories("com.geleigeit.LinenAndFlowers.repository")
public class EtsyToDoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtsyToDoApplication.class, args);
	}
}