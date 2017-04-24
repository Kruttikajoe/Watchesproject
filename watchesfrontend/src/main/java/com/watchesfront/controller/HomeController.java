package com.watchesfront.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HomeController {
	
	@RequestMapping("/")
	public String showHome()
	{
		return "Home";
	}

	@RequestMapping("/Login")
	public ModelAndView showlogin()
	{
		ModelAndView mv= new ModelAndView("Login");
		return mv;
	}

	
	@RequestMapping("/validate")
	public ModelAndView showMessage(@RequestParam("username")String uname,@RequestParam("password")String pass)
	{
		ModelAndView mv;
		if (uname.equals("NIIT")&&pass.equals("NIIT"))
		{
			mv=new ModelAndView("Home");
			mv.addObject("loggedInUser", "User");
			return mv;
		}
		else if(pass.equals("admin"))
		{
			mv=new ModelAndView("Admin");
			mv.addObject("loggedInUser","Admin");
			return mv;
		}
		else
		{
			mv=new ModelAndView("Login");
			return mv;
		}
	}
	@RequestMapping("/Signup")
	public ModelAndView showsignup()
	{
		ModelAndView mv= new ModelAndView("Signup");
		return mv;
	}
	
	@RequestMapping("/AddCategory")
	public ModelAndView showCategory()
	{
		ModelAndView mv= new ModelAndView("AddCategory");
		return mv;
	}
	
	@RequestMapping("/AddSupplier")
	public ModelAndView showSupplier()
	{
		ModelAndView mv= new ModelAndView("AddSupplier");
		return mv;
	}
	

}


