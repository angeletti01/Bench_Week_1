package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {
	
	public List<Product> findByProductName(String productName);
	public<Product> void findByPriceBetween(int low, int high);

}
