package com.example.SpringRedisProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringRedisProject.entity.Product;
import com.example.SpringRedisProject.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/")
	public String welcomePage() {
		return "Hi! Welcome to my farm";
	}
	
	@PostMapping("/add")
	public Product saveProduct(@RequestBody Product product) {
		System.out.println(product);
		return productRepository.save(product);
	}
	
	@GetMapping("/getall")
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	
	@GetMapping("/findbyid/{id}")
	public Product getProductByID(@PathVariable int id) {
		return productRepository.findProductByID(id);
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public String deleteProduct(@PathVariable int id) {
		return productRepository.deleteProduct(id);
	}
}
