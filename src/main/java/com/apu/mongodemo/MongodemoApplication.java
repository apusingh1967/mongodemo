package com.apu.mongodemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MongodemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodemoApplication.class, args);
	}

	// @Bean 
	public CommandLineRunner run(ProductRepository repository, CategoryRepository categoryRepository){
		return args -> {
			categoryRepository.insert(Category.builder().name("iphone").description("all i phones").build());
			categoryRepository.insert(Category.builder().name("samsung").description("all sam phones").build());
			categoryRepository.insert(Category.builder().name("bell").description("all bell phones").build());
		};
	}

}
