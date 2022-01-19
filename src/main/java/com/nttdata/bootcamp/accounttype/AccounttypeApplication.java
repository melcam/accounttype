package com.nttdata.bootcamp.accounttype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class AccounttypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccounttypeApplication.class, args);
	}

}
