package com.fuad.test.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.fuad.test.model.Cart;

@Transactional
public interface CartRepository extends CrudRepository<Cart, Long>{
	
}
