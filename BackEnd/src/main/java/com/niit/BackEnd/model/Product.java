package com.niit.BackEnd.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Entity
@Table
@Component


public class Product {
	@Id
	private String pid;
	private String name;
	private String description;
	private Double price;
	private int quantity;
	@Transient
	private MultipartFile pimg;

	public MultipartFile getPimg() {
		return pimg;
	}
	public void setPimg(MultipartFile pimg) {
		this.pimg = pimg;
	}
	public Suppliers getSuppliers() {
		return suppliers;
	}
	public void setSuppliers(Suppliers suppliers) {
		this.suppliers = suppliers;
	}
	public Product()
	{
		this.pid="PROD"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	@ManyToOne
	@JoinColumn(name="catid")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="sid")
	private Suppliers suppliers;
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
