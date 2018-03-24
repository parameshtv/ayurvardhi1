package com.niit.BackEnd.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class Pay {
	@Id
private String payid;
private String paymethod;
private String paymentstatus;
public Pay()
{
	this.payid="PAY"+UUID.randomUUID().toString().substring(30).toUpperCase();
}
public String getPayid() {
	return payid;
}
public void setPayid(String payid) {
	this.payid = payid;
}
public String getPaymethod() {
	return paymethod;
}
public void setPaymethod(String paymethod) {
	this.paymethod = paymethod;
}
public String getPaymentstatus() {
	return paymentstatus;
}
public void setPaymentstatus(String paymentstatus) {
	this.paymentstatus = paymentstatus;
}
}
