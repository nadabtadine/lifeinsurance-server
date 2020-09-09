package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Order;
import com.example.demo.model.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository <OrderItem, Long>{

	public List<OrderItem> findByOrderid(Long orderid);
}
