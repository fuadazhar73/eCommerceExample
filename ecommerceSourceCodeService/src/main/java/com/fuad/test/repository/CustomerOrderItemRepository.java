package com.fuad.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.fuad.test.model.CustomerOrderItem;

public interface CustomerOrderItemRepository extends CrudRepository <CustomerOrderItem, Long>{

}
