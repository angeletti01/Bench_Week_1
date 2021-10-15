package com.example.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArithmeticCalculatorTest {
	
	ArithmeticCalculator calculator;
	int expected = 0;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		System.out.println("setupBefore called");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("teearDown called");
	}

	@BeforeEach
	void setUp() throws Exception {
		calculator = new ArithmeticCalculator();
		expected = 20;
		System.out.println("setup called");
	}

	@AfterEach
	void tearDown() throws Exception {
		calculator = null;
	}


	@Test
	void testAdd() {
//		int expected = 20;
		int actual = calculator.add(10, 10);
		assertEquals(expected, actual); // expected and actual	
	}
	@Test
	@DisplayName("Testing add method -1")
	void testAdd1() {
//		int expected = 20;
		int actual = calculator.add(10, 10);
		assertEquals(expected, actual); // expected and actual			
	}
	
	@Test
	@DisplayName("Testing add method -1")
	void testAdd2() {
//		int expected = 20;
		int actual = calculator.add(10, 10);
		assertEquals(expected, actual); // expected and actual			
	}
	
	@Test
	@DisplayName("Testing add method -1")
	void testAdd3() {
//		int expected = 20;
		int actual = calculator.add(10, 10);
		assertEquals(expected, actual); // expected and actual			
	}

	@Test
	void testGetMessage() {
		String expected = "Hello and welcome to My App";
		String actual = calculator.getMessage();
		assertEquals(expected, actual);
	}

}
