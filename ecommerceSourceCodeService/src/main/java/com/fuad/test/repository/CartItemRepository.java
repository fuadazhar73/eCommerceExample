package com.fuad.test.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.fuad.test.model.CartItem;

@Transactional
public interface CartItemRepository extends CrudRepository<CartItem, Long>{

}
