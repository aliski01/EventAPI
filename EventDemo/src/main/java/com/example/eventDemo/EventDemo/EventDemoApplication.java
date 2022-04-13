package com.example.eventDemo.EventDemo;


import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EventDemoApplication {

	@Bean 
	public RestTemplate getRestTemplate(){

		return new RestTemplate();	  
	}

	@Bean
	public HttpEntity<String> getEntity()
	{
		HttpHeaders headers = new HttpHeaders();
		headers .setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		return  new HttpEntity<String>(headers);
	}


	public static void main(String[] args) {
		SpringApplication.run(EventDemoApplication.class, args);


	}

}
