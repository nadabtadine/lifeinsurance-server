package com.example.demo.repository;

import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Order;
@Repository
public interface OrderRepository extends JpaRepository <Order, Long>{

	LocalDate date = java.time.LocalDate.now();
	@Override
	public <S extends Order> S save(S entity);
	
//	@Async
//	@Query(value="insert into order(cid, firstname, lastname, email, phone, address, date, totalprice) values(?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8)", nativeQuery=true)
//	public void addProduct(Long cid, String firstname, String lastname, String email, String phone, String address, String date, Float totalprice);

}
