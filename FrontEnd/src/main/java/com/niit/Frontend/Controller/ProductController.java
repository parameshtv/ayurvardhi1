package com.niit.Frontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.BackEnd.dao.CategoryDao;
import com.niit.BackEnd.dao.ProductDao;
import com.niit.BackEnd.dao.SuppliersDao;
import com.niit.BackEnd.model.Category;
import com.niit.BackEnd.model.Product;
import com.niit.BackEnd.model.Suppliers;
import com.niit.Frontend.FileInput.FileInput;
@Controller
public class ProductController {
	@Autowired
	Product product;
	
	@Autowired
	ProductDao productDao;
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	Suppliers suppliers;
	@Autowired
	SuppliersDao suppliersDao;
	String path="E:\\java\\FrontEnd\\src\\main\\webapp\\resources\\images";
	

	@RequestMapping("/product")
	public ModelAndView Product()
	{
		ModelAndView mv= new ModelAndView("Product");
		mv.addObject("product", new Product());
		List<Product> prod= productDao.list();
		mv.addObject("prodlist", prod);
		List<Category> catlist=categoryDao.list();
		mv.addObject("categories",catlist);
		List<Suppliers> supplylist=suppliersDao.list();
		mv.addObject("supplier",supplylist);
		return mv;
		 
	}
	
	
	@RequestMapping("/addprod")
	public ModelAndView addprod(@ModelAttribute("product")Product product)
	{
		ModelAndView mv1= new ModelAndView("redirect:/Product");
		mv1.addObject("product", product);
		if(productDao.saveorupdate(product)==true)
		{
			FileInput.upload(path,product.getPimg(),product.getPid()+",jpg");
			System.out.println("product is saved");
			mv1.addObject("msg", "product is saved");
		}
		else
		{
			System.out.println("product is not saved");
			mv1.addObject("msg", "product is not saved");
		}
		List<Category> catlist=categoryDao.list();
		mv1.addObject("categories",catlist);
		List<Suppliers> supplylist=suppliersDao.list();
		mv1.addObject("supplier",supplylist);
		return mv1;
	}
	@RequestMapping("/editprod/{pid}")
	public ModelAndView editproduct(@PathVariable("pid")String pid)
	{
		ModelAndView mv= new ModelAndView("Product");
		product= productDao.getproduct(pid);
		mv.addObject("product", product);
		List<Product> prod= productDao.list();
		mv.addObject("prodlist", prod);
		List<Category> catlist=categoryDao.list();
		mv.addObject("categories",catlist);
		List<Suppliers> supplylist=suppliersDao.list();
		mv.addObject("supplier",supplylist);
		return mv;
	}
	@RequestMapping("/deleteprod/{pid}")
	public ModelAndView deleteprod(@PathVariable("pid")String pid)
	{
		ModelAndView mv=new ModelAndView("redirect:/Product");
		product=productDao.getproduct(pid);
		if(productDao.delete(product)==true)
		{
			mv.addObject("msg1", "product Delete");
		}
		else
		{
			mv.addObject("msg2", "productnotdelete");
		}
		return mv;
	}
}
