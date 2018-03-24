package com.niit.BackEnd.dao;

import java.util.List;

import com.niit.BackEnd.model.Category;



public interface CategoryDao {
	
	public boolean saveorupdate(Category category);
	
	public boolean delete (Category category);
	
	public Category getcategory(String catId);
	
	public List<Category> list();

} 
