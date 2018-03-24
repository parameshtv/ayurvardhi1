package com.niit.BackEnd.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class Orderitem {
	
	@Id
	private String orderitemid;
	private float grandtotal;
	private String orderdata;
	private String ordertime;
	@ManyToOne
	@JoinColumn(name="orderid")
	private Order order;
	public Orderitem()
	{
		this.orderitemid="ORDIT"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getOrderitemid() {
		return orderitemid;
	}
	public void setOrderitemid(String orderitemid) {
		this.orderitemid = orderitemid;
	}
	public float getGrandtotal() {
		return grandtotal;
	}
	public void setGrandtotal(float grandtotal) {
		this.grandtotal = grandtotal;
	}
	public String getOrderdata() {
		return orderdata;
	}
	public void setOrderdata(String orderdata) {
		this.orderdata = orderdata;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	

}
