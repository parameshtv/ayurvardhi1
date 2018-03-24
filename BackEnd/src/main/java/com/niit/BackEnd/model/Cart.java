package com.niit.BackEnd.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class Cart {
	@Id
	private String cartid;
	private double grand_total=0.0;
	private int total_items=0;
	@OneToMany(mappedBy="cart")
	private List<Cartitem> cartitem;
	
	public String getCartid() {
		return cartid;
	}
	public void setCartid(String cartid) {
		this.cartid = cartid;
	}
	public double getGrand_total() {
		return grand_total;
	}
	public void setGrand_total(double grand_total) {
		this.grand_total = grand_total;
	}
	public int getTotal_items() {
		return total_items;
	}
	public void setTotal_items(int total_items) {
		this.total_items = total_items;
	}
	
	

}
