package com.niit.Frontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.niit.BackEnd.dao.UsersDao;

import com.niit.BackEnd.model.Users;
@Controller
public class UsersController {
	@Autowired
	Users users;
	
	@Autowired
	UsersDao usersDao;
	

	@RequestMapping("/Users")
	public ModelAndView Users()
	{
		ModelAndView mv= new ModelAndView("Users");
		mv.addObject("users", new Users());
		List<Users> use= usersDao.list();
		mv.addObject("userlist", use);
		return mv;
		
	}
	
	
	@RequestMapping("/adduser")
	public ModelAndView adduser(@ModelAttribute("Users")Users	 users)
	{
		ModelAndView mv1= new ModelAndView("redirect:/Users");
		if(usersDao.saveorupdate(users)==true)
		{
			System.out.println("Users is saved");
			mv1.addObject("msg", "Users is saved");
		}
		else
		{
			System.out.println("Users is not saved");
			mv1.addObject("msg", "Users is not saved");
		}
		return mv1;
	}
}
