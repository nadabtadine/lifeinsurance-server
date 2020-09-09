package com.example.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.PayPalClient;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/api7")
public class PaymentController {
	
	@Autowired
	PayPalClient paypalclient;
	
	@PostMapping("/create/payment")
	public Map<String, Object> makePayment(@RequestParam("totalPrice") String totalPrice) {
		return paypalclient.createPayment(totalPrice);
	}

	@PostMapping("/complete/payment")
	public Map<String, Object> completePayment(HttpServletRequest request, @RequestParam("paymentId") String paymentId,
			@RequestParam("payerId") String payerId) throws JsonGenerationException, JsonMappingException, IOException {
		return paypalclient.completePayment(request);
	}
}
