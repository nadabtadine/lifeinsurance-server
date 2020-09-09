package com.example.demo.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Order;

@Repository
public interface OrderRepository extends JpaRepository <Order, Long>{

//@Async
//@Query(value="insert into order(cid, firstname, lastname, email, phone, address, country, state, zip, date, payment, totalprice)"
//		+ " values(?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12)", nativeQuery=true)
//public void newOrder(Long cid, String firstname, String lastname, String email,  
//		String address, String phone, String country, String state, String zip, Date date, String payment, float totalprice);
	
	@Query(value="select o from Order o where o.cid = ?1")
	public Order getOrder(Long cid);

	public List<Order> findByCid(Long cid);
	
	public Optional<Order> findById(Long id);
}
