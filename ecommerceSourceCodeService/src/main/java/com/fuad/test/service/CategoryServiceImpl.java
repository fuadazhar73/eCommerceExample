package com.fuad.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuad.test.model.Category;
import com.fuad.test.repository.CategoryRepository;
import com.fuad.test.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepostitory;
	
	public List<String> getAllSubCategory(){
		return categoryRepostitory.findAllSubCategoryName();
	}
	
	public List<String> getAllMainCategory(){
		return categoryRepostitory.findAllMainCategoryName();
	}
	
	public List<Category> getAllCategory(){
		return (List<Category>) categoryRepostitory.findAll();
	}
	
	public void save(Category category){
		categoryRepostitory.save(category);
	}
	
	public void delete(Long categoryId){
		categoryRepostitory.delete(categoryId);
	}
	
	public Category getCategoryById(Long categoryId){
		return categoryRepostitory.findOne(categoryId);
	}
}
