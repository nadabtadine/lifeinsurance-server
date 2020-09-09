package com.example.demo.model;

import java.util.ArrayList;

public class OrderPids {

   public Package products[];
	
	public OrderPids(Package products[], float totalprice) {
		this.products = products;
		this.totalprice = totalprice;
	} 
	public OrderPids() {
		// TODO Auto-generated constructor stub
	}
	public float totalprice;
    
	public Package[] getProducts() {
		return products;
	}
	public void setProducts(Package[] products) {
		this.products = products;
	}
	public float getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	} 
}
