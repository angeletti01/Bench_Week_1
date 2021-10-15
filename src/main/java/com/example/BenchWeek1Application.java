package com.example;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BenchWeek1Application {
		
	public static void main(String[] args) {
		SpringApplication.run(BenchWeek1Application.class, args);
		
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.next();
		System.out.println("Enter the environment (PROD-DEV :");
		
		
//		SpringApplication application = new SpringApplication(BenchWeek1Application.class);
//		application.setAdditionalProfiles(choice);
//		application.run(args);
//		
//		ConfigurableApplicationContext context = SpringApplication.run(BenchWeek1Application.class, args);
//		
//		String allBeans[] = context.getBeanDefinitionNames();		
//		//Array.sort(allBeans);
//		
//		for(String bean:allBeans) {System.out.println(bean);}	
			
	}
	@Bean
	public RestTemplate getRestTemplate() 
	{
		return new RestTemplate();
		}

}
