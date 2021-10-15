package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ProductDAO;
import com.example.model.Product;
import com.example.service.ProductService;

@RestController
@RequestMapping("product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	  
	@Autowired 
	ProductDAO productDAO;
	
	@Autowired
	ProductService productService;
	
	@GetMapping
	public List<Product> getProducts(@RequestParam (required = false) String productName)
	{
		List<Product> products = new ArrayList<Product>();
		
		if(productName == null) {
			
			products = productDAO.findAll();
		}
		else
		{
			products = productService.getProducts();
		}
		
		return products;
	}
	
		// delete
		// http://localhost:9090/product/2009
		@DeleteMapping("{productId}")
		public ResponseEntity<String> deleteProduct(@PathVariable("productId") int productId) {

			ResponseEntity<String> responseEntity = new ResponseEntity<String>(HttpStatus.OK);
			// two scenario
			if (productService.isProductExists(productId)) {
				productService.deleteProduct(productId);
				responseEntity = new ResponseEntity<String>("Product deleted successfully", HttpStatus.NO_CONTENT);
				// product exists
			} else {
				responseEntity = new ResponseEntity<String>("Product not deleted successfully", HttpStatus.OK);
			}

			return responseEntity;
		}
	
	@PostMapping()
	public ResponseEntity<String> addProduct(@RequestBody Product product) 
	{
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(HttpStatus.OK);
		
		
		if(productService.isProductExists(product.getProductId())) 
		{
			
			responseEntity = new ResponseEntity<String>("Product with product id: " + product.getProductId() + "already exists", HttpStatus.CONFLICT);
		}
		
		else 
		{
			productService.addProduct(product);
			responseEntity = new ResponseEntity<String>("Product saved successfully" + product.getProductId(), HttpStatus.CREATED);
		}
		
		return responseEntity;
	}
	
	
	@GetMapping("{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable("productId") int productId) 
	{
		ResponseEntity<Product> responseEntity = new ResponseEntity<Product>(HttpStatus.OK);
		Product product = new Product();
		
		if(productService.isProductExists(productId)) 
		{
			product = productService.getProduct(productId);
			responseEntity = new ResponseEntity<Product>(product,HttpStatus.FOUND);
		}
		
		else 
		{
			responseEntity = new ResponseEntity<Product>(product,HttpStatus.NO_CONTENT);
		}
		
		return responseEntity;
	}
}

