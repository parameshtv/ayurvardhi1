package com.niit.BackEnd.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class Shipping {
private String fname;
private String lname;
@Id
private String shippingid;
private String houseno;
private String country;
private String city;
private String pincode;
private String Email;
private String mobileno;
public Shipping()
{
	this.shippingid="SHIP"+UUID.randomUUID().toString().substring(30).toUpperCase();
}

@ManyToOne
@JoinColumn(name="userid")
private Users users;
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getMobileno() {
	return mobileno;
}
public void setMobileno(String mobileno) {
	this.mobileno = mobileno;
}
public Users getUsers() {
	return users;
}
public void setUsers(Users users) {
	this.users = users;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getShippingid() {
	return shippingid;
}
public void setShippingid(String shippingid) {
	this.shippingid = shippingid;
}
public String getHouseno() {
	return houseno;
}
public void setHouseno(String houseno) {
	this.houseno = houseno;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}


}
