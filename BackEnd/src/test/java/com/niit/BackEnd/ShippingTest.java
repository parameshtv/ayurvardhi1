package com.niit.BackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BackEnd.dao.ShippingDao;
import com.niit.BackEnd.model.Shipping;

public class ShippingTest {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Shipping ship=(Shipping)ctx.getBean("shipping");
		ShippingDao shipDao=(ShippingDao)ctx.getBean("shippingDao");
		ship.setShippingid("s101");
		ship.setHouseno("35");
		ship.setCountry("India");
		ship.setCity("bangalore");
		
		ship.setPincode("560056");
		ship.setEmail("p@gmail.com");
		ship.setMobileno("9900432421");
		ship.setFname("Ayesha");
		ship.setLname("Mohiddin");
		if(shipDao.saveorupdate(ship)==true) {
			System.out.println("Ship is saved successfully");
		}
		else
		{
			System.out.println("Ship is not saved");
		}
		ship.setShippingid("s102");
		ship.setHouseno("35");
		ship.setCountry("India");
		ship.setCity("bangalore");
		ship.setPincode("560056");
		ship.setEmail("p@gmail.com");
		ship.setMobileno("9900432421");
		ship.setFname("paramesh");
		ship.setLname("t_v");
		if(shipDao.saveorupdate(ship)==true) {
			System.out.println("Ship is saved successfully");
		}
		else
		{
			System.out.println("Ship is not saved");
		}
		ship=shipDao.getShipping("s101");
		if(shipDao.delete(ship)==true)
		{
			System.out.println("Ship deleted");
	}
		else
		{
			System.out.println("Ship not deleted");
		}
		ship=shipDao.getShipping("s101");
		if(ship==null) {
			System.out.println("Ship not found");
		}
		else
		{
			System.out.println(ship.getShippingid());
			System.out.println(ship.getHouseno());
			System.out.println(ship.getCountry());
			System.out.println(ship.getCity());
			System.out.println(ship.getPincode());
			System.out.println(ship.getEmail());
			System.out.println(ship.getMobileno());
			System.out.println(ship.getFname());
			System.out.println(ship.getLname());
		}
		
		}
}
