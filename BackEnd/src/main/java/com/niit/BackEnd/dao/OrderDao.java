package com.niit.BackEnd.dao;

import java.util.List;

import com.niit.BackEnd.model.Order;

public interface OrderDao {

public boolean saveorupdate(Order order);
	
	public boolean delete (Order order);
	
	public Order getorder(String orderid);
	
	
	public List<Order> list();

}
