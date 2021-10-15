package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity
@Table(name = "product", schema = "bench")
@Component
public class Product {
	
	@Id
	private int productId;
	private String productName;
	private int quantityOnHand;
	private int price;
	

}
