package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.transaction.Transactional;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;
import com.example.demo.model.ShoppingCartItem;

@Repository
public interface ShoppingCartRepository extends JpaRepository <ShoppingCartItem, Long>{

	@Override
	public List<ShoppingCartItem> findAll();
	
	@Override
	public boolean existsById(Long id);

	@Override
	public <S extends ShoppingCartItem> boolean exists(Example<S> example);

	public CompletableFuture<ShoppingCartItem> findOneByCidAndPid(Long cid, Long pid);
	
	
//	public boolean findOneByCidAndPid(Long cid, Long pid);
	
	@Override
	public void delete(ShoppingCartItem sci);
	
	@Modifying
	@Query(value="delete from ShoppingCartItem sc where sc.cid=:cid and sc.pid=:pid")
	public void remove(@Param("cid")Long cid,@Param("pid")Long pid);
	
	
	// get customer's shopping cart
	@Async
//	@Query(value="select sc.cid, sc.pid from ShoppingCartItem sc join Product p on sc.pid=p.id where sc.cid = ?1")
//	@Query(value="select sc.cid, sc.pid, p.name, p.image from Shoppingcart sc, Product p where sc.pid=p.id and sc.cid= ?1")
//	@Query(value="select p.id, p.image, p.name, sc.pid from Product p, Shoppingcart sc where sc.pid=p.id and sc.cid= ?1")
	@Query(value="select p from Product p join ShoppingCartItem sc on p.id=sc.pid where sc.cid = ?1")
	public ArrayList<Product> getShoppingCart(Long cid);

	// add product to customer's shopping cart
	@Async
	@Query(value="insert into shoppingcart(pid, cid) values(?1, ?2)", nativeQuery=true)
	public void addProduct(Long pid, Long cid);
	
	
}
