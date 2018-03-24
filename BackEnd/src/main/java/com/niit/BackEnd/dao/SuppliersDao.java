package com.niit.BackEnd.dao;

import java.util.List;


import com.niit.BackEnd.model.Suppliers;

public interface SuppliersDao{
	
	public boolean saveorupdate(Suppliers suppliers);
	
	public boolean delete (Suppliers suppliers);
	
	public Suppliers getsuppliers(String supplyId);
	
	
	public List<Suppliers> list();

}
