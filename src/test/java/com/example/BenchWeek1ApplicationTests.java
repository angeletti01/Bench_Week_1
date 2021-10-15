package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class BenchWeek1ApplicationTests {

	@LocalServerPort
	private String port;
	
	@Autowired
	RestTemplate restTemplate; // you can make HTTPrequests with RestTemplate
	private String baseURL = "http://localhost";
//	private String restAPIURL = "http://localhost";
	
	@BeforeEach
	public void setUp() throws MalformedURLException
	{
		URL url = new URL(baseURL +":"+ port);
		
	}

	@Test
	public void contextLoads() throws MalformedURLException {
		
		URL url = new URL(baseURL +":"+ port);
		
		ResponseEntity<String> response = restTemplate.getForEntity(url.toString(), String.class);
		
		restTemplate.getForEntity(url.toString(), String.class);		
		assertEquals("Welcome to Revature", response.getBody());
	}
	
//	@Test
//	@DisplayName("Testing Message")
//	public void testMessageAPI() throws MalformedURLException
//	{
//		URL url = new URL(baseURL +":"+ port + "/message");
//		restTemplate.getForEntity(url.toString(), String.class);
//		String expected = "Works well";
//		
//				
//		ResponseEntity<String> response = restTemplate.getForEntity(null, null);
//		
//		assertEquals(expected, response.getBody());
//	}

}
