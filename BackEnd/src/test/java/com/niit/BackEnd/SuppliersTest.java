package com.niit.BackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BackEnd.dao.SuppliersDao;
import com.niit.BackEnd.model.Suppliers;

public class SuppliersTest {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Suppliers suppliers=(Suppliers)ctx.getBean("suppliers");
		SuppliersDao suppliersDao=(SuppliersDao)ctx.getBean("suppliersDao");
		suppliers.setSid("s103");
		suppliers.setSname("supplier3");
		suppliers.setAddress("About supplier3");
		suppliers.setPhno("9904994995");
		suppliers.setEmailid("param043@gmail.com");
		suppliers.setPwd("ptv111");
		if(suppliersDao.saveorupdate(suppliers)==true) {
			System.out.println("supplier is saved successfully");
		}
		else
		{
			System.out.println("Supplier is not saved");
		}
		suppliers.setSid("s102");
		suppliers.setSname("supplier3");
		suppliers.setAddress("About supplier3");
		suppliers.setPhno("9904994995");
		if(suppliersDao.saveorupdate(suppliers)==true) {
			System.out.println("supplier is saved successfully");
		}
		else
		{
			System.out.println("Supplier is not saved");
		}
		suppliers=suppliersDao.getsuppliers("s102");
		if(suppliersDao.delete(suppliers)==true)
		{
			System.out.println("Supplier deleted");
		}
		else
		{
			System.out.println("Supplier not deleted");
		}
		suppliers=suppliersDao.getsuppliers("s102");
		if(suppliers==null) {
			System.out.println("Supplier not found");
		}
		else
		{
			System.out.println(suppliers.getSid());
			System.out.println(suppliers.getSname());
			System.out.println(suppliers.getAddress());
			System.out.println(suppliers.getPhno());
		}
		
		}
}
