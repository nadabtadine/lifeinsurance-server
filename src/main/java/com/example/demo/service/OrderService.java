package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.model.Order;
import com.example.demo.model.OrderItem;
import com.example.demo.model.Product;
import com.example.demo.repository.OrderItemRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderItemRepository orderitemRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	// make new order
		//public CompletableFuture<String> newOrder(Order order) throws InterruptedException {
		//	orderRepository.save(order);
		//	return CompletableFuture.supplyAsync(() -> "");
		//}	

//@Async
//public void newOrder(Order order){
//orderRepository.newOrder(order.getCid(), order.getFirstname(), order.getLastname(), 
//		order.getEmail(), order.getPhone(), order.getAddress(), 
//		order.getCountry(), order.getState(), order.getZip(), 
//		order.getDate(), order.getPayment(), order.getTotalprice());
//	}
	
	public void newOrder(Order order){
		this.orderRepository.save(order);
	}
	
	public Optional<Order> getOne(Long id) {
		return this.orderRepository.findById(id);
	}
	
	public List<Order> getAll(Long cid) {
		List<Order> o=this.orderRepository.findByCid(cid);
		for(Order orders:o) {
		List<OrderItem> oi =orderitemRepository.findByOrderid(orders.getId());
		for(OrderItem orderitems:oi) {
			Product p =productRepository.findById(orderitems.getPid()).orElse(null);
			if(p!=null) {
			orders.getProducts().add(p);
			}
		}
	}
		return o;
	}
	
}
