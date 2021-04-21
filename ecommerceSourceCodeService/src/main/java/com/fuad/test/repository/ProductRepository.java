package com.fuad.test.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.fuad.test.model.Category;
import com.fuad.test.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>, PagingAndSortingRepository<Product, Long>{
	
	List<Product> findAllByOrderByProductViewsDesc();
	
	List<Product> findAllByProductCategory(Category category);
	
}
