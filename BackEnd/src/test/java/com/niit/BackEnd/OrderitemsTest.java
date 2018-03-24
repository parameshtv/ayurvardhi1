package com.niit.BackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BackEnd.dao.OrderDao;
import com.niit.BackEnd.dao.OrderitemDao;
import com.niit.BackEnd.model.Order;
import com.niit.BackEnd.model.Orderitem;

public class OrderitemsTest {
	public static void main(String args[])
	{
	

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Orderitem orderitem=(Orderitem)ctx.getBean("orderitem");
		OrderitemDao orderitemdao=(OrderitemDao)ctx.getBean("orderitemDao");
		orderitem.setOrderitemid("oi101");
		Order order=(Order)ctx.getBean("order");
		OrderDao orderDao=(OrderDao)ctx.getBean("orderDao");
	order=orderDao.getorder("o102");
	orderitem.setOrder(order);
		
		if(orderitemdao.saveorupdate(orderitem)==true) {
			System.out.println("orderItem is saved successfully");
	}
		else
		{
			System.out.println("orderItem is not saved");
		}
order=orderDao.getorder("o101");
		
		if(orderitemdao.saveorupdate(orderitem)==true) {
			System.out.println("orderItem is saved successfully");
		}
		else
		{
			System.out.println("orderItem is not saved");
	}
		
	//	orderitem=orderitem.getOrderitemid("o102");
	//	if(orderitem.delete(orderitem)==true)
	//	{
	//		System.out.println("Orderitems deleted");
		//}
	//	else
	//	{			System.out.println("Orderitems not deleted");
	//}
		orderitem=orderitemdao.getorderitem("oi101");
		if(orderitem==null) {
			System.out.println("OrderItems not found");
		}
		else
		{
			System.out.println(orderitem.getOrderitemid());
//	System.out.println(orderitem.getPid());
		}
		
		}
}






