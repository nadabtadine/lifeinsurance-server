package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;
import com.example.demo.model.ShoppingCartItem;

@Repository
public interface ShoppingCartRepository extends JpaRepository <ShoppingCartItem, Long>{

	@Override
	public List<ShoppingCartItem> findAll();

	// get customer's shopping cart
	@Async
	@Query(value="select sc.cid, sc.pid from ShoppingCartItem sc join Product p on sc.pid=p.id where sc.cid = ?1")
	public ArrayList<ShoppingCartItem> getShoppingCart(Long cid);

	// add product to customer's shopping cart
	@Async
	@Query(value="insert into shoppingcart(pid, cid) values(?1, ?2)", nativeQuery=true)
	public void addProduct(Long pid, Long cid);
	
	
}
