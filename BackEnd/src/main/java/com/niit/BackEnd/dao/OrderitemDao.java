package com.niit.BackEnd.dao;

import java.util.List;

import com.niit.BackEnd.model.Orderitem;

public interface OrderitemDao {
public boolean saveorupdate(Orderitem orderitem);
	
	public boolean delete (Orderitem orderitem);
	
	public Orderitem  getorderitem(String orderitemId);
	
	
	public List<Orderitem> list();


}
