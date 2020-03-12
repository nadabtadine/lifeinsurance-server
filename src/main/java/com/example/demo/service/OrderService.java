package com.example.demo.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.model.Order;
import com.example.demo.model.OrderItem;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	// make new order
		@Async
		public CompletableFuture<String> newOrder(Order order) throws InterruptedException {
			orderRepository.save(order);
			return CompletableFuture.supplyAsync(() -> "");
		}	
		
}
