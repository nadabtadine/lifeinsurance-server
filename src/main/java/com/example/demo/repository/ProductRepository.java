package com.example.demo.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Product;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long> {


	@Override
	public <S extends Product> S save(S entity);

	@Override
	public Optional<Product> findById(Long id);

	public List<Product> findByCategory(int category);
	
	@Override
	public Product getOne(Long id);
	
	@Override
	public long count();

	@Override
	public void deleteById(Long id);

	@Override
	public List<Product> findAll();

	@Override
	public List<Product> findAll(Sort sort);

	



	
}
