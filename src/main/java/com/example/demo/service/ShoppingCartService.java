package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.model.ShoppingCartItem;
import com.example.demo.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService {

	@Autowired
	ShoppingCartRepository shoppingcartRepository;

	
	public ArrayList<ShoppingCartItem> getShoppingCart(Long cid) {
		return this.shoppingcartRepository.getShoppingCart(cid);
	}
	
	public void addProduct(ShoppingCartItem sci){
		this.shoppingcartRepository.save(sci);
	}	
}
