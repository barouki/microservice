package com.test.springbdd;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@SpringBootApplication
public class SpringBddApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringBddApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBddApplication.class, args);		
	}

}
