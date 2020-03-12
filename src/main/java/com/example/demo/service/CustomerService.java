package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.model.AuthenticatedCustomer;
import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import com.example.demo.model.ShoppingCartItem;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.Email;
import com.example.demo.service.Info;

import javassist.NotFoundException;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	// Get customers
	public CompletableFuture<Collection<Customer>> getCustomers(){
		log.info("retrieving all customers");
		return customerRepository.getCustomers();
	}
	
	// Get customer by name
	public CompletableFuture<Collection<Customer>> getCustomersByName(String name){
		log.info("retrieving customers by name");
		return customerRepository.getCustomerByName(name);
	}
	
	// Get customer by id
	public CompletableFuture<Customer> getCustomerById(Long id){
		log.info("retrieving customer by id");
		return customerRepository.getCustomerById(id);
	}
	
	// Insert new customer
	@Async
	public CompletableFuture<String> insertCustomer(Customer customer) throws InterruptedException {
		Email email = new Email(customer.getEmail());
		Info info = new Info(customer.getName());
		log.info("inserting new customer");
		customerRepository.save(customer);
		email.start();
		info.start();
		return CompletableFuture.supplyAsync(() -> "");
	}	
	
	public CompletableFuture<Customer> exists(Customer ac) throws NotFoundException {
		log.info("checking if customer exists in db");
		return customerRepository.findOneByUsernameAndPassword(ac.getUsername(), ac.getPassword());
	}

	public CompletableFuture<Customer> signedUp(Customer ac) throws NotFoundException {
		log.info("checking if customer exists in db");
		return customerRepository.findOneByEmail(ac.getEmail());
	}


}