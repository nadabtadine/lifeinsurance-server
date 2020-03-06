package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.scheduling.annotation.Async;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;

import com.example.demo.model.AuthenticatedCustomer;
import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import com.example.demo.model.ShoppingCartItem;

import javassist.NotFoundException;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long>{

	// Get customers
	@Async 
	@Query(value="select * from customer", nativeQuery=true)
	public CompletableFuture<Collection<Customer>> getCustomers();

	// Get customer by name
	@Async	
	@Query(value="select * from customer where name = ?1", nativeQuery=true)
	public CompletableFuture<Collection<Customer>> getCustomerByName(String name);
		
	
	// Get customer by id
	@Async
	@Query(value="select * from customer where id = ?1", nativeQuery=true)
	public CompletableFuture<Customer> getCustomerById(Long id);
	
	// get customer's credentials
	public CompletableFuture<Customer> findOneByUsernameAndPassword(String username, String password);
	

	
}