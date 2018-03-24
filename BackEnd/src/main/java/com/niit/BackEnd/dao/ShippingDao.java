package com.niit.BackEnd.dao;

import java.util.List;

import com.niit.BackEnd.model.Shipping;

public interface ShippingDao {
public boolean saveorupdate(Shipping shipping);
	
	public boolean delete (Shipping shipping);
	
	public Shipping getShipping(String shippingid);
	
	
	public List<Shipping> list();


}
