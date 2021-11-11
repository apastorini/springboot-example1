package com.gofore.grandma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.gofore.grandma.repository.IngredientsRepository;
import com.gofore.grandma.repository.ReceipeRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = "com.gofore.grandma")
@EnableSwagger2
public class GrandmaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(GrandmaApplication.class, args);
		
	}

}
