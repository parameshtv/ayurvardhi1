package com.niit.BackEnd.dao;

import java.util.List;

import com.niit.BackEnd.model.Cart;

public interface CartDao {
	public boolean saveorupdate(Cart cart);
	
	public boolean delete (Cart cart);
	
	public Cart getcart(String cartid);
	
	public List<Cart> list();


}
