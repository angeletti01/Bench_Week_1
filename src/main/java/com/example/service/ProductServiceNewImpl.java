package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ProductDAO;
import com.example.model.Product;

@Service
public class ProductServiceNewImpl implements ProductService {
	
	@Autowired
	ProductDAO productDAO;
	
	@Override
	public void addProduct(Product product) 
	{
		System.out.println("Adding the product");
		
		if(product.getPrice()<0)
			productDAO.save(product);
	}

	@Override
	public void updateProduct(Product product) {
		productDAO.save(product);		
	}

	@Override
	public List<Product> getProducts() {
		
		return productDAO.findAll(); 
	}

	@Override
	public void deleteProduct(int productId) {
		productDAO.deleteById(productId);		
	}

	@Override
	public Product getProduct(int productId) {
		Optional<Product> prod = productDAO.findById(productId);
		return prod.get();

	}

	@Override
	public boolean isProductExists(int productId) {
		productDAO.existsById(productId);
		return false;
	}

	@Override
	public List<Product> getProductByName(String productName) {	
		return null;
	}

	@Override
	public List<Product> getProductByPriceRange(int lower, int upper) {
		
		return null;
	}
	

}
