package com.niit.Frontend.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String Home()
	{
		return "Navbar2";
	}
	
//	@RequestMapping("/Category")
//public String Category() {
//		return "Category";
//	}
//	@RequestMapping("/Product")
//public String Product() {
//		return "Product";
//		
//	}
//	@RequestMapping("/Suppliers")
//public String Suppliers() {
//		return "Suppliers";
//	}
}
