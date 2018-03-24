package com.niit.BackEnd.dao;

import java.util.List;

import com.niit.BackEnd.model.Cartitem;


public interface CartitemDao {
public boolean saveorupdate(Cartitem cartitem);
	
	public boolean delete (Cartitem cartitem);
	
	public Cartitem getcartitem(String cartitemid);
	
	public List<Cartitem> list();


}
