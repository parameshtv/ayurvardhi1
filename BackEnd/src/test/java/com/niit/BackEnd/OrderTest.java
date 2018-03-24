package com.niit.BackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BackEnd.dao.BillingDao;
import com.niit.BackEnd.dao.OrderDao;
import com.niit.BackEnd.dao.Paydao;
import com.niit.BackEnd.dao.ShippingDao;
import com.niit.BackEnd.dao.UsersDao;
import com.niit.BackEnd.model.Billing;
import com.niit.BackEnd.model.Order;
import com.niit.BackEnd.model.Pay;
import com.niit.BackEnd.model.Shipping;
import com.niit.BackEnd.model.Users;

public class OrderTest {

	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Order order=(Order)ctx.getBean("order");
		OrderDao orderDao=(OrderDao)ctx.getBean("orderDao");
		order.setOrderid("o101");
		Billing billing=(Billing)ctx.getBean("billing");
		BillingDao billingDao=(BillingDao)ctx.getBean("billingDao");
		billing=billingDao.getbilling("b102");
		order.setBilling(billing);
		Pay pay=(Pay)ctx.getBean("pay");
		Paydao paydao=(Paydao)ctx.getBean("payDao");
		pay =paydao.getpay("pay102");
		order.setPay(pay);
		Shipping ship=(Shipping)ctx.getBean("shipping");
		ShippingDao shipDao=(ShippingDao)ctx.getBean("shippingDao");
		ship =shipDao.getShipping("s102");
		order.setShipping(ship);
		Users user=(Users)ctx.getBean("users");
		UsersDao userDao=(UsersDao)ctx.getBean("usersDao");
		user=userDao.getUsers("u102");
		order.setUsers(user);
	
		order.setGrandtotal(36.0);
		order.setOrdertime("5:00 pm");
		if(orderDao.saveorupdate(order)==true) {
			System.out.println("order is saved successfully");
		}
		else
		{
			System.out.println("order is not saved");
		}
		order.setOrderid("o102");
		order.setGrandtotal(36.0);
		order.setOrdertime("5:00 pm");
		if(orderDao.saveorupdate(order)==true) {
			System.out.println("order is saved successfully");
		}
		else
		{
			System.out.println("order is not saved");
		}
		order=orderDao.getorder("o101");
		if(orderDao.delete(order)==true)
		{
			System.out.println("Order deleted");
		}
		else
		{
			System.out.println("Order not deleted");
		}
		order=orderDao.getorder("o101");
		if(order==null) {
			System.out.println("Order not found");
		}
		else
		{
			System.out.println(order.getOrderid());
			System.out.println(order.getGrandtotal());
			System.out.println(order.getDate());
			System.out.println(order.getOrdertime());
		}
		
		}
}
