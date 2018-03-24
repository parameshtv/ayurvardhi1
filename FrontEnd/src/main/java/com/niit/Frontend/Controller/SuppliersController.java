package com.niit.Frontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.niit.BackEnd.dao.SuppliersDao;
import com.niit.BackEnd.model.Product;
import com.niit.BackEnd.model.Suppliers;
@Controller
public class SuppliersController {
	@Autowired
	Suppliers suppliers;
	
	@Autowired
	SuppliersDao suppliersDao;;
	

	@RequestMapping("/Suppliers")
	public ModelAndView Suppliers()
	{
		ModelAndView mv= new ModelAndView("Suppliers");
		mv.addObject("suppliers", new Suppliers());
		List<Suppliers> supplier= suppliersDao.list();
		mv.addObject("supplylist", supplier);
		return mv;
		
	}
	
	
	@RequestMapping("/addsupply")
	public ModelAndView addsupply(@ModelAttribute("suppliers")Suppliers	 suppliers)
	{
		ModelAndView mv1= new ModelAndView("redirect:/Suppliers");
		if(suppliersDao.saveorupdate(suppliers)==true)
		{
			System.out.println("supplier is saved");
			mv1.addObject("msg", "supplier is saved");
		}
		else
		{
			System.out.println("supplier is not saved");
			mv1.addObject("msg", "supplier is not saved");
		}
		return mv1;
	}
	@RequestMapping("/editsupply/{sid}")
	public ModelAndView editsuppliers(@PathVariable("sid")String sid)
	{
		ModelAndView mv= new ModelAndView("Suppliers");
		suppliers= suppliersDao.getsuppliers(sid);
		mv.addObject("suppliers", suppliers);
		List<Suppliers> supplier= suppliersDao.list();
		mv.addObject("supplylist", supplier);
		return mv;
	}
	@RequestMapping("/deletesupply/{supplyid}")
	public ModelAndView deletesupply(@PathVariable("supplyid")String supplyid)
	{
		ModelAndView mv=new ModelAndView("redirect:/Suppliers");
		suppliers=suppliersDao.getsuppliers(supplyid);
		if(suppliersDao.delete(suppliers)==true)
		{
			mv.addObject("msg1", "supplier Delete");
		}
		else
		{
			mv.addObject("msg2", "suppliernotdelete");
		}
		return mv;
	}
}
