package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Order;
import com.example.demo.model.OrderInfos;
import com.example.demo.model.OrderItem;
import com.example.demo.model.OrderPids;
import com.example.demo.model.OrderRequest;
import com.example.demo.model.Package;
import com.example.demo.model.Product;
import com.example.demo.service.OrderItemService;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;

import javassist.NotFoundException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api6")
public class OrderController {

	@Autowired
	OrderService orderservice;
	
	@Autowired
	OrderItemService orderitemservice;
	
	@Autowired
	ProductService productService;
	
	// Set success header value
	private static Map<String, String> successHeaderKV;
	static {
		successHeaderKV = new HashMap<>();
		successHeaderKV.put("successCode", "00");
		successHeaderKV.put("successDesc", "Success");
		successHeaderKV.put("contentType", "application/json");
	}

	
	// make new order
	@PostMapping(value = "/order/{cid}")
	public ResponseEntity<Order> add(@PathVariable("cid") Long cid, @RequestBody OrderRequest request) throws NullPointerException, NotFoundException, InterruptedException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("responseCode", successHeaderKV.get("successCode"));
		headers.add("responseDesc", successHeaderKV.get("successDesc"));
		headers.add(HttpHeaders.CONTENT_TYPE, successHeaderKV.get("contentType"));
		
		Order order= new Order();
		
		order.setCid(cid);
		order.setFirstname(request.getOrderinfos().getFirstname());
		order.setLastname(request.getOrderinfos().getLastname());
		order.setEmail(request.getOrderinfos().getEmail());
		order.setAddress(request.getOrderinfos().getAddress());
		order.setPhone(request.getOrderinfos().getPhone());
		order.setCountry(request.getOrderinfos().getCountry());
		order.setState(request.getOrderinfos().getState());
		order.setZip(request.getOrderinfos().getZip());
		order.setPayment(request.getOrderinfos().getPayment());
		order.setTotalprice(request.getOrderitems().getTotalprice());
		order.setDate(new Date());

		orderservice.newOrder(order);
	
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(order);
		
	}
	
	//new order item
	@PostMapping(value = "/orderitem/{orderid}")
	public ResponseEntity<Long> neworderitem(@PathVariable("orderid") Long orderid, @RequestBody Long pid)  throws NullPointerException, NotFoundException, InterruptedException{
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("responseCode", successHeaderKV.get("successCode"));
		headers.add("responseDesc", successHeaderKV.get("responseDesc"));
		headers.add(HttpHeaders.CONTENT_TYPE, successHeaderKV.get("contentType"));
		

		OrderItem orderitem= new OrderItem();
		orderitem.setOrderid(orderid);
		orderitem.setPid(pid);
		
		orderitemservice.newOrderItem(orderitem);
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(pid);
	}
	
	
	// Get orders by cid
	@GetMapping(value = "/orders/{cid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Order>> getOrders(@PathVariable("cid") Long cid){
		HttpHeaders headers = new HttpHeaders();
		headers.add("responseCode", successHeaderKV.get("successCode"));
		headers.add("successDesc", successHeaderKV.get("successDesc"));
		headers.add(HttpHeaders.CONTENT_TYPE, successHeaderKV.get("contentType"));
		
		List<Order>o  = new ArrayList<Order>();
		o=orderservice.getAll(cid);
		
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(o);
	}
	
	// Get order items by orderid
	@GetMapping(value = "/orderitem/{orderid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<OrderItem>> getOrderItems(@PathVariable("orderid") Long orderid){
		HttpHeaders headers = new HttpHeaders();
		headers.add("responseCode", successHeaderKV.get("successCode"));
		headers.add("successDesc", successHeaderKV.get("successDesc"));
		headers.add(HttpHeaders.CONTENT_TYPE, successHeaderKV.get("contentType"));
		
		List<OrderItem>oi  = new ArrayList<OrderItem>();
		oi=orderitemservice.getAll(orderid);
		
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(oi);
	}
	
	// Get order by id
	@GetMapping(value ="/invoice/{orderid}", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<Order>> getProductById(@PathVariable("orderid") Long orderid){
		HttpHeaders headers = new HttpHeaders();
		headers.add("responseCode", successHeaderKV.get("successCode"));
		headers.add("responseDesc", successHeaderKV.get("responseDesc"));
		headers.add(HttpHeaders.CONTENT_TYPE, successHeaderKV.get("contentType"));
		
		Optional<Order> o = orderservice.getOne(orderid);
		
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(o);
	}
	
	
}
