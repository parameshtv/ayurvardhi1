package com.niit.BackEnd.dao;

import java.util.List;

import com.niit.BackEnd.model.Pay;

public interface Paydao {
public boolean saveorupdate(Pay pay);
	
	public boolean delete (Pay pay);
	
	public Pay getpay(String payId);
	
	
	public List<Pay> list();


}
