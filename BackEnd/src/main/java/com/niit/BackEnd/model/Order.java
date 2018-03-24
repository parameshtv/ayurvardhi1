package com.niit.BackEnd.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name="Orders")
@Component
public class Order {
	@Id
private String orderid;
private double grandtotal;
private String ordertime;
private String date;
public Order()
{
	this.orderid="ORDER"+UUID.randomUUID().toString().substring(30).toUpperCase();
}

@OneToMany(mappedBy="order")
private List<Orderitem> orderitem;



@OneToOne
@JoinColumn(name="shippingid")
private Shipping shipping;



@OneToOne
@JoinColumn(name="billId")
private Billing billing;



@OneToOne
@JoinColumn(name="userid")
private Users users;


@OneToOne
@JoinColumn(name="payid")
private Pay pay;



public String getOrderid() {
	return orderid;
}
public void setOrderid(String orderid) {
	this.orderid = orderid;
}
public List<Orderitem> getOrderitem() {
	return orderitem;
}
public void setOrderitem(List<Orderitem> orderitem) {
	this.orderitem = orderitem;
}
public Shipping getShipping() {
	return shipping;
}
public void setShipping(Shipping shipping) {
	this.shipping = shipping;
}
public Billing getBilling() {
	return billing;
}
public void setBilling(Billing billing) {
	this.billing = billing;
}
public Users getUsers() {
	return users;
}
public void setUsers(Users users) {
	this.users = users;
}
public Pay getPay() {
	return pay;
}
public void setPay(Pay pay) {
	this.pay = pay;
}
public double getGrandtotal() {
	return grandtotal;
}
public void setGrandtotal(double grandtotal) {
	this.grandtotal = grandtotal;
}
public String getOrdertime() {
	return ordertime;
}
public void setOrdertime(String ordertime) {
	this.ordertime = ordertime;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}

}
