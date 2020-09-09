package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.OrderItem;
import com.example.demo.model.Product;
import com.example.demo.repository.OrderItemRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class OrderItemService {

	@Autowired
	OrderItemRepository orderitemRepository;
	

	@Autowired
	ProductRepository productRepository;
	
	public void newOrderItem(OrderItem orderitem){
		this.orderitemRepository.save(orderitem);
	}
	
	public List<OrderItem> getAll(Long orderid) {
		List<OrderItem> oi =orderitemRepository.findByOrderid(orderid);
		for(OrderItem orderitems:oi) {
			Product p =productRepository.findById(orderitems.getPid()).orElse(null);
			if(p!=null) {
				orderitems.getProducts().add(p);
			}
		}
		return oi;
	}
}
