package com.niit.BackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BackEnd.dao.CartDao;
import com.niit.BackEnd.model.Cart;

public class Carttest {
	public static void main(String args[])
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Cart cart=(Cart)ctx.getBean("cart");
		CartDao cartDao=(CartDao)ctx.getBean("cartDao");
		cart.setCartid("ca102");
		cart.setGrand_total(36.00);
	
		cart.setTotal_items(7);
		if(cartDao.saveorupdate(cart)==true) {
			System.out.println("cart is saved successfully");
		}
		else
		{
			System.out.println("cart is not saved");
		}
		cart.setCartid("ca101");
		cart.setGrand_total(39.00);
	
		cart.setTotal_items(7);
		if(cartDao.saveorupdate(cart)==true) {
			System.out.println("cart is saved successfully");
		}
		else
		{
			System.out.println("cart is not saved");
		}
		cart=cartDao.getcart("ca102");
		if(cartDao.delete(cart)==true)
		{
			System.out.println("Cart deleted");
		}
		else
		{
			System.out.println("Cart not deleted");
		}
		cart=cartDao.getcart("ca101");
		if(cart==null) {
			System.out.println("Cart not found");
		}
		else
		{
			System.out.println(cart.getCartid());
			System.out.println(cart.getGrand_total());
			System.out.println(cart.getTotal_items());
			
		}
		
		}

}
