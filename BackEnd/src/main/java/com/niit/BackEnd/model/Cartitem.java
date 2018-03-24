package com.niit.BackEnd.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class Cartitem {
	@Id
	private String cartitemid;
	private float price;
	public Cartitem()
	{
		this.cartitemid="CIT"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	@ManyToOne
	@JoinColumn(name="cartid")
	private Cart cart;
	@OneToOne
	@JoinColumn(name="pid")
	private Product product;
	public String getCartitemid() {
		return cartitemid;
	}
	public void setCartitemid(String cartitemid) {
		this.cartitemid = cartitemid;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	

}
