package com.niit.BackEnd.dao;

import java.util.List;

import com.niit.BackEnd.model.Billing;


public interface BillingDao {
public boolean saveorupdate(Billing billing);
	
	public boolean delete (Billing billing);
	
	public Billing  getbilling(String billSSid);
	
	public List<Billing> list();


}
