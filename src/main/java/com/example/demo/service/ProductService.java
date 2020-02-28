package com.example.demo.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAll(){
		return this.productRepository.findAll();
	}
	
	public Optional<Product> getOne(long id) {
		return this.productRepository.findById(id);
	}
	
	public List<Product> getAll(int category) {
		return this.productRepository.findByCategory(category);
	}
	public Product save(Product p) {
		return this.productRepository.save(p);
	}
}
