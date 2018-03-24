package com.niit.BackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BackEnd.dao.CartDao;
import com.niit.BackEnd.dao.CartitemDao;
import com.niit.BackEnd.dao.ProductDao;
import com.niit.BackEnd.model.Cart;
import com.niit.BackEnd.model.Cartitem;
import com.niit.BackEnd.model.Product;

public class CartitemsTest {
	public static void main(String args[])
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Cartitem cartitem=(Cartitem)ctx.getBean("cartitem");
		CartitemDao cartitemDao=(CartitemDao)ctx.getBean("cartitemDao");
		Product product=(Product)ctx.getBean("product");
		ProductDao productDao=(ProductDao)ctx.getBean("productDao");
		product=productDao.getproduct("p101");
		cartitem.setProduct(product);
		Cart cart=(Cart)ctx.getBean("cart");
		CartDao cartDao=(CartDao)ctx.getBean("cartDao");
		cart =cartDao.getcart("ca103");
		
		cartitem.setCartitemid("cai101");
		cartitem.setPrice(56);
		cartitem.setCart(cart);
		if(cartitemDao.saveorupdate(cartitem)==true) {
			System.out.println("cartItem is saved successfully");
		}
		else
		{
			System.out.println("cartItem is not saved");
		}
		cartitem.setCartitemid("cai102");
		cartitem.setPrice(56);
		if(cartitemDao.saveorupdate(cartitem)==true) {
			System.out.println("cartItem is saved successfully");
		}
		else
		{
			System.out.println("cartItem is not saved");
		}
		cartitem=cartitemDao.getcartitem("cai101");
		if(cartitemDao.delete(cartitem)==true)
		{
			System.out.println("Cartitem deleted");
		}
		else
		{
			System.out.println("Cartitem not deleted");
		}
		cartitem=cartitemDao.getcartitem("cai101");
		if(cartitem==null) {
			System.out.println("CartItem not found");
		}
		else
		{
			System.out.println(cartitem.getCartitemid());
			System.out.println(cartitem.getPrice());
		}
		
		}
}
