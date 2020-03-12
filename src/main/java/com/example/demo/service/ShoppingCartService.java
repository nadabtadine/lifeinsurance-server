package com.example.demo.service;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.model.ShoppingCartItem;
import com.example.demo.repository.ShoppingCartRepository;

import javassist.NotFoundException;

@Service
public class ShoppingCartService {

	@Autowired
	ShoppingCartRepository shoppingcartRepository;

	
	public boolean existsById(Long id) {
		return this.shoppingcartRepository.existsById(id);
	}

	public CompletableFuture<ShoppingCartItem> exists(ShoppingCartItem sci){
		return shoppingcartRepository.findOneByCidAndPid(sci.getCid(), sci.getPid());
	}
	
//	public boolean exists(ShoppingCartItem sci) throws NotFoundException {
//		return shoppingcartRepository.findOneByCidAndPid(sci.getCid(),sci.getPid());
//	}

	public ArrayList<Product> getShoppingCart(Long cid) {
		return this.shoppingcartRepository.getShoppingCart(cid);
	}
	
	
	public void addProduct(ShoppingCartItem sci){
		this.shoppingcartRepository.save(sci);
	}

	public void delete(ShoppingCartItem sci) {
		this.shoppingcartRepository.delete(sci);
	}
	
	public void remove(Long cid,Long pid) {
		this.shoppingcartRepository.remove(cid,pid);
	}
}
