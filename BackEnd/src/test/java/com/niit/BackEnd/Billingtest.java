package com.niit.BackEnd;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BackEnd.dao.BillingDao;
import com.niit.BackEnd.dao.UsersDao;
import com.niit.BackEnd.model.Billing;
import com.niit.BackEnd.model.Users;

public class Billingtest {

	public static void main(String args[])
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Billing bill=(Billing)ctx.getBean("billing");
		BillingDao billingDao=(BillingDao)ctx.getBean("billingDao");
		Users user=(Users)ctx.getBean("users");
		UsersDao userDao=(UsersDao)ctx.getBean("usersDao");
		user=userDao.getUsers("u102");
		bill.setBillId("b101");
		bill.setHouseno("c11");
		bill.setCountry("India");
		bill.setCity("Bangalore");
		bill.setPincode("560056");
		bill.setEmail("p@gmail.com");
		bill.setMobno("9874563210");
		user=userDao.getUsers("u102");
		bill.setUsers(user);
		if(billingDao.saveorupdate(bill)==true) {
			System.out.println("Bill is saved successfully");
		}
		else
		{
			System.out.println("Bill is not saved");
		}
		
		bill.setBillId("b102");
		bill.setHouseno("c11");
		bill.setCountry("India");
		bill.setCity("Bangalore");
		bill.setPincode("560056");
		bill.setEmail("p@gmail.com");
		bill.setMobno("9874563210");
		user=userDao.getUsers("u102");
		bill.setUsers(user);
		if(billingDao.saveorupdate(bill)==true) {
			System.out.println("Bill is saved successfully");
		}
		else
		{
			System.out.println("Bill is not saved");
		}
		
		bill=billingDao.getbilling("b101");
		if(billingDao.delete(bill)==true)
		{
			System.out.println("Bill deleted");
		}
		else
		{
			System.out.println("Bill not deleted");
		}
		bill=billingDao.getbilling("b102");
		if(bill==null) {
			System.out.println("Bill not found");
		}
		else
		{
			System.out.println(bill.getBillId());
			System.out.println(bill.getHouseno());
			System.out.println(bill.getCountry());
			System.out.println(bill.getCity());
			System.out.println(bill.getPincode());
			System.out.println(bill.getEmail());
			System.out.println(bill.getMobno());
			
		}
		
		
		}
}

