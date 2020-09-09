package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.model.ShoppingCartItem;
import com.example.demo.service.ShoppingCartService;

import javassist.NotFoundException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api4")
public class ShoppingCartController {


	@Autowired
	ShoppingCartService shoppingcartService;
	
	// Set success header value
	private static Map<String, String> successHeaderKV;
	static {
		successHeaderKV = new HashMap<>();
		successHeaderKV.put("successCode", "00");
		successHeaderKV.put("successDesc", "Success");
		successHeaderKV.put("contentType", "application/json");
	}
	
	// add product to shopping cart
	@PostMapping(value = "/shoppingcart/{cid}")
	public ResponseEntity<ShoppingCartItem> addProduct(@RequestBody Product p, @PathVariable("cid") Long cid) throws NotFoundException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("responseCode", successHeaderKV.get("successCode"));
		headers.add("responseDesc", successHeaderKV.get("successDesc"));
		headers.add(HttpHeaders.CONTENT_TYPE, successHeaderKV.get("contentType"));
	
		ShoppingCartItem i= new ShoppingCartItem(cid, p.getId());
		
		shoppingcartService.exists(i).thenAccept((sci) -> {
			if(sci == null) {
				shoppingcartService.addProduct(i);	
			}	
		});
		
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(i);
		
//			  shoppingcartService.addProduct(i);
//			  return ResponseEntity.status(HttpStatus.OK).headers(headers).body(i);
//		}
//		else {
//			return ResponseEntity.status(HttpStatus.OK).headers(headers).body(null);
//		}
	}	
	
	// Get shopping cart
		@GetMapping(value ="/shoppingcart/{cid}", produces= MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<ArrayList<Product>> getShoppingCart(@PathVariable("cid") Long cid){
			HttpHeaders headers = new HttpHeaders();
			headers.add("responseCode", successHeaderKV.get("successCode"));
			headers.add("responseDesc", successHeaderKV.get("responseDesc"));
			headers.add(HttpHeaders.CONTENT_TYPE, successHeaderKV.get("contentType"));
			
			ArrayList<Product> sc= new ArrayList<Product>();
			
			sc = shoppingcartService.getShoppingCart(cid);
	
			return ResponseEntity.status(HttpStatus.OK).headers(headers).body(sc);
		}
		
//		@DeleteMapping("/shoppingcart/{id}")
//		public void delete(@RequestBody ShoppingCartItem sci,@PathVariable int id) throws NotFoundException {	
//			shoppingcartService.delete(sci);
//		}
		
		@Transactional
		@DeleteMapping("/shoppingcart/{cid}/{pid}")
		public ResponseEntity<Long> delete(@PathVariable Long cid,@PathVariable Long pid) {	
			shoppingcartService.remove(cid,pid);
			return ResponseEntity.status(HttpStatus.OK).body(pid);
		}
		
}
