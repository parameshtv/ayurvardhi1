package com.niit.BackEnd.dao;

import java.util.List;


import com.niit.BackEnd.model.Product;

public interface ProductDao {
	
	public boolean saveorupdate(Product product);
	
	public boolean delete (Product product);
	
	public Product getproduct(String pId);
	
	
	public List<Product> list();

}
