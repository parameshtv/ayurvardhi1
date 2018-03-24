package com.niit.Frontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.BackEnd.dao.CategoryDao;
import com.niit.BackEnd.model.Category;

@Controller
public class CategoryController {
	
	@Autowired
	Category category;
	
	@Autowired
	CategoryDao categoryDao;
	

	@RequestMapping("/Category")
	public ModelAndView Category()
	{
		ModelAndView mv= new ModelAndView("Category");
		mv.addObject("category", new Category());
		List<Category> categories= categoryDao.list();
		mv.addObject("catlist", categories);
		return mv;
		
	}
	
	
	@RequestMapping("/addcat")
	public ModelAndView addcat(@ModelAttribute("category")Category category)
	{
		ModelAndView mv1= new ModelAndView("redirect:/Category");
		List<Category> categories= categoryDao.list();
		mv1.addObject("catlist", categories);
		if(categoryDao.saveorupdate(category)==true)
		{
			System.out.println("Category is saved");
			mv1.addObject("msg", "Category is saved");
		}
		else
		{
			System.out.println("Category is not saved");
			mv1.addObject("msg", "Category is not saved");
		}
		return mv1;
	}
	
	
	
	@RequestMapping("/editcat/{catid}")
	public ModelAndView editcategory(@PathVariable("catid")String catid)
	{
		ModelAndView mv= new ModelAndView("Category");
		category= categoryDao.getcategory(catid);
		mv.addObject("category", category);
		List<Category> categories= categoryDao.list();
		mv.addObject("catlist", categories);
		return mv;
	}
	
	
	@RequestMapping("/deletecat/{catid}")
	public ModelAndView deletecat(@PathVariable("catid")String catid)
	{
		ModelAndView mv=new ModelAndView("redirect:/Category");
		category=categoryDao.getcategory(catid);
		if(categoryDao.delete(category)==true)
		{
			mv.addObject("msg1", "Category Delete");
		}
		else
		{
			mv.addObject("msg2", "Categorynotdelete");
		}
		return mv;
	}
	
	
	
	
	
	
}
