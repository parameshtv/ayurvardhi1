package com.niit.BackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BackEnd.dao.Paydao;
import com.niit.BackEnd.model.Pay;

public class PayTest {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Pay pay=(Pay)ctx.getBean("pay");
		Paydao paydao=(Paydao)ctx.getBean("payDao");
		pay.setPayid("pay101");
		pay.setPaymethod("cash");
		pay.setPaymentstatus("processing");
		if(paydao.saveorupdate(pay)==true) {
			System.out.println("pay is saved successfully");
		}
		else
		{
			System.out.println("pay is not saved");
		}
		pay.setPayid("pay102");
		pay.setPaymethod("cash");
		pay.setPaymentstatus("processing");
		if(paydao.saveorupdate(pay)==true) {
			System.out.println("pay is saved successfully");
		}
		else
		{
			System.out.println("pay is not saved");
		}
		pay=paydao.getpay("pay101");
		if(paydao.delete(pay)==true)
		{
			System.out.println("Pay deleted");
		}
		else
		{
			System.out.println("Pay not deleted");
		}
		pay=paydao.getpay("pay101");
		if(pay==null) {
			System.out.println("Pay not found");
		}
		else
		{
			System.out.println(pay.getPayid());
			System.out.println(pay.getPaymethod());
			System.out.println(pay.getPaymentstatus());
		}
		
		}
}
