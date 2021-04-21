package com.fuad.test.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fuad.test.model.Product;
import com.fuad.test.model.ProductComment;

public interface ProductCommentRepository extends CrudRepository<ProductComment, Long>{
	List<ProductComment> findByProduct(Product product);
}
