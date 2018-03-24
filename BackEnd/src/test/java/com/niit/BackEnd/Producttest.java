package com.niit.BackEnd;

import java.util.function.Supplier;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BackEnd.dao.CategoryDao;
import com.niit.BackEnd.dao.ProductDao;
import com.niit.BackEnd.dao.SuppliersDao;
import com.niit.BackEnd.model.Category;
import com.niit.BackEnd.model.Product;
import com.niit.BackEnd.model.Suppliers;

public class Producttest {

	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Product product=(Product)ctx.getBean("product");
		ProductDao productDao=(ProductDao)ctx.getBean("productDao");
		Category category=(Category)ctx.getBean("category");
		CategoryDao categoryDao=(CategoryDao)ctx.getBean("categoryDao");
		category=categoryDao.getcategory("c101");
	product.setCategory(category);
		Suppliers supplier=(Suppliers)ctx.getBean("suppliers");
		SuppliersDao supplierDao=(SuppliersDao)ctx.getBean("suppliersDao");
		supplier=supplierDao.getsuppliers("s102");
	//product.set
		
		product.setPid("p101");
		product.setName("product1");
		product.setDescription("About Product1");
		product.setPrice(5000.00);
		product.setQuantity(8);
		if(productDao.saveorupdate(product)==true) {
			System.out.println("product is saved successfully");
		}
		else
		{
			System.out.println("product is not saved");
		}
		
		product.setPid("p102");
		product.setName("product1");
		product.setDescription("About Product1");
		product.setPrice(5000.00);
		product.setQuantity(8);
		if(productDao.saveorupdate(product)==true) {
			System.out.println("product is saved successfully");
		}
		else
		{
			System.out.println("product is not saved");
		}
		
		product=productDao.getproduct("p102");
		if(productDao.delete(product)==true)
		{
			System.out.println("Product deleted");
		}
		else
		{
			System.out.println("Product not deleted");
		}
		product=productDao.getproduct("p103");
		if(product==null) {
			System.out.println("Product not found");
		}
		else
		{
			System.out.println(product.getPid());
			System.out.println(product.getName());
			System.out.println(product.getDescription());
			System.out.println(product.getPrice());
			System.out.println(product.getQuantity());
		
		}
}
}
