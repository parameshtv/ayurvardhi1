package com.niit.BackEnd;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BackEnd.dao.CategoryDao;
import com.niit.BackEnd.model.Category;

public class CategoryTest {
	public static void main(String args[])
	{
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	ctx.scan("com.niit.*");
	ctx.refresh();
	Category category=(Category)ctx.getBean("category");
	CategoryDao categoryDao=(CategoryDao)ctx.getBean("categoryDao");
	category.setCatid("c101");
	category.setCatname("c1");
	if(categoryDao.saveorupdate(category)==true) {
	System.out.println("category is saved successfully");
	}
	else		{
	System.out.println("category is not saved");
	}
	category.setCatid("c102");
	category.setCatname("c2");
	if(categoryDao.saveorupdate(category)==true) {
		System.out.println("category is saved successfully");
	}
	else
	{
	System.out.println("category is not saved");
	}
	category=categoryDao.getcategory("c102");
	if(categoryDao.delete(category)==true)
	{
		System.out.println("Category deleted");
	}
	else
	{
		System.out.println("Category not deleted");
	}
	category=categoryDao.getcategory("c103");
	if(category==null) {
		System.out.println("Category not found");
	}
	else
	{
		System.out.println(category.getCatid());
		System.out.println(category.getCatname());
	}
	}
}