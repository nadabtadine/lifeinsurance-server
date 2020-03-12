package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.model.Order;
import com.example.demo.model.OrderItem;
import com.example.demo.service.OrderService;

import javassist.NotFoundException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api6")
public class OrderController {

	@Autowired
	OrderService orderservice;
	
	// Set success header value
	private static Map<String, String> successHeaderKV;
	static {
		successHeaderKV = new HashMap<>();
		successHeaderKV.put("successCode", "00");
		successHeaderKV.put("successDesc", "Success");
		successHeaderKV.put("contentType", "application/json");
	}

	
	// make new order
	@PostMapping(value = "/order/{cid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> add(@PathVariable("cid") Long cid,@RequestBody Order order) throws InterruptedException, NotFoundException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("responseCode", successHeaderKV.get("successCode"));
		headers.add("responseDesc", successHeaderKV.get("successDesc"));
		headers.add(HttpHeaders.CONTENT_TYPE, successHeaderKV.get("contentType"));
		
		CompletableFuture<String> cf = orderservice.newOrder(order);
		
		String added = null;
		try {
			added = cf.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(added);
		
	}
	
}
