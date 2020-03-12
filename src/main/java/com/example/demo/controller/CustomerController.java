package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.JWT.JwtUtil;
import com.example.demo.model.AuthenticatedCustomer;
import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import com.example.demo.model.ShoppingCartItem;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ShoppingCartService;

import javassist.NotFoundException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class CustomerController {

	private static final String token = null;

	@Autowired
	CustomerService customerService;
	

	// Set success header value
	private static Map<String, String> successHeaderKV;
	static {
		successHeaderKV = new HashMap<>();
		successHeaderKV.put("successCode", "00");
		successHeaderKV.put("successDesc", "Success");
		successHeaderKV.put("contentType", "application/json");
	}

	// Get customers
	@GetMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Customer>> getCustomers(){
		HttpHeaders headers = new HttpHeaders();
		headers.add("responseCode", successHeaderKV.get("successCode"));
		headers.add("successDesc", successHeaderKV.get("successDesc"));
		headers.add(HttpHeaders.CONTENT_TYPE, successHeaderKV.get("contentType"));
		
		CompletableFuture<Collection<Customer>> cf = customerService.getCustomers();
		Collection<Customer> customers = Collections.emptyList();
		
		try {
			customers = cf.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(customers);
	}
	
	
	// Get customers by name
	@GetMapping(value = "/customers/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Customer>> getCustomersByName(@PathVariable String name) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("responseCode", successHeaderKV.get("successCode"));
		headers.add("successDesc", successHeaderKV.get("successDesc"));
		headers.add(HttpHeaders.CONTENT_TYPE, successHeaderKV.get("contentType"));

		CompletableFuture<Collection<Customer>> cf = customerService.getCustomersByName(name);
		Collection<Customer> customersByName = Collections.emptyList();
		
		try {
			customersByName = cf.get();
			System.out.println("CompletableFuture Status: " + cf.isDone());
			System.out.println("Finish Exceptionally Status: " + cf.isCompletedExceptionally());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(customersByName);
	}
	
	// Get customer by id
	@GetMapping(value ="/customers/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id){
		HttpHeaders headers = new HttpHeaders();
		headers.add("responseCode", successHeaderKV.get("successCode"));
		headers.add("responseDesc", successHeaderKV.get("responseDesc"));
		headers.add(HttpHeaders.CONTENT_TYPE, successHeaderKV.get("contentType"));
		
		CompletableFuture<Customer> cf = customerService.getCustomerById(id);
		Customer customer = null;
		
		try {
			customer = cf.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch(ExecutionException e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(customer);
	}

	
	@PostMapping(value = "/login", consumes = "application/json")
	public ResponseEntity<Customer> login(@RequestBody Customer ac, HttpServletResponse response) throws NotFoundException {

				
//		String token= JwtUtil.generateToken(ac);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("responseCode", successHeaderKV.get("successCode"));
		headers.add("responseDesc", successHeaderKV.get("successDesc"));
		headers.add(HttpHeaders.CONTENT_TYPE, successHeaderKV.get("contentType"));
//		headers.add("token", token);
		
		CompletableFuture<Customer> cf = customerService.exists(ac);
		Customer customer = null;
		
		try {
			customer = cf.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch(ExecutionException e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(customer);
	}
	

	// Insert new customer
	@PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insertCustomer(@RequestBody Customer customer) throws InterruptedException, NotFoundException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("responseCode", successHeaderKV.get("successCode"));
		headers.add("responseDesc", successHeaderKV.get("successDesc"));
		headers.add(HttpHeaders.CONTENT_TYPE, successHeaderKV.get("contentType"));
		
		if(customerService.signedUp(customer) == null) {
		CompletableFuture<String> cf = customerService.insertCustomer(customer);
		
		String insertCustomer = null;
		try {
			insertCustomer = cf.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(insertCustomer);
		}else {
			return ResponseEntity.status(HttpStatus.OK).headers(headers).body(null);
		}
	}
	

	
}