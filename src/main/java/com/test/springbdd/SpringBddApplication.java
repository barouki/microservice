package com.test.springbdd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpringBddApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringBddApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBddApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CategoryRepository repository) {
		return (args) -> {
		    log.info("A criar produtos");

		    Category c1 = new Category("xpto", 1);
		    Category c2 = new Category("xpto", 2);
		    
			repository.save(c1);
			repository.save(c2);
			
			 for (Category c : repository.findAll()) {
		          log.info(c.toString());
		    }  
			 
		};
	}

}
