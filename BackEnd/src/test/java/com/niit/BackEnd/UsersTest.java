package com.niit.BackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BackEnd.dao.BillingDao;
import com.niit.BackEnd.dao.UsersDao;
import com.niit.BackEnd.model.Billing;
import com.niit.BackEnd.model.Users;

public class UsersTest {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Users user=(Users)ctx.getBean("users");
		UsersDao userDao=(UsersDao)ctx.getBean("usersDao");
		Billing bill= (Billing)ctx.getBean("billing");
		BillingDao billDao=(BillingDao)ctx.getBean("billingDao");
		user.setUserid("u102");
		user.setName("user");
		user.setAddr("About user2");
		user.setPhno("9123456789");
		user.setEmailid("ayesha@gmail.com");
		user.setPwd("moin");
		bill= billDao.getbilling("b102");
		user.setBilling(bill);
		if(userDao.saveorupdate(user)==true) {
			System.out.println("User is saved successfully");
		}
		else
		{
			System.out.println("User is not saved");
		}
		user=userDao.getUsers("u102");
		if(user==null) {
			System.out.println("User not found");
		}
		else
		{
			System.out.println(user.getUserid());
			System.out.println(user.getName());
			System.out.println(user.getAddr());
			System.out.println(user.getPhno());
			System.out.println(user.getEmailid());
			System.out.println(user.getPwd());
		}
		
		}
}
