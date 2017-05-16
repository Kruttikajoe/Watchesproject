package com.watchesfront.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.watchesbackend.DAO.CategoryDAO;
import com.niit.watchesbackend.DAO.UserDAO;
import com.niit.watchesbackend.model.Category;
import com.niit.watchesbackend.model.User;



@Controller

public class HomeController {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	User user;
	
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
	@RequestMapping("/Denied")
	public ModelAndView showDenied()
	{
		ModelAndView mv=new ModelAndView("Denied");
		return mv;
	}
	
	@RequestMapping(value="/login_session_attributes")
	
	public String login_session_attributes(HttpSession session, Model model, @RequestParam(value="username") String id)
	{
		String name=SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("inside security check");
		session.setAttribute("name", name);
		System.out.println(name);
		user=userDAO.get(id);
		int x=user.getUserid();
		session.setAttribute("email", user.getEmailid());
		session.setAttribute("loggedInUser", user.getUsername());
		System.out.println("x value is:"+x);
		session.setAttribute("loggedInUserID", x);
		session.setAttribute("LoggedIn", "true");
		
		Collection<GrantedAuthority> authorities=(Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		String role="ROLE_USER";
		for(GrantedAuthority authority:authorities)
		{
			if(authority.getAuthority().equals(role))
			{
				return "Home";
			}
			else
			{
				session.setAttribute("isAdmin", "true");
				
			}
		}
			return "Admin";
		}
	
	@RequestMapping("/perform_logout")
	public ModelAndView showLogout(HttpServletRequest request,HttpSession session)
	{
		ModelAndView mv=new ModelAndView("index");
		session.setAttribute("logoutMessage", "You have successfully logged out");
		session.setAttribute("loggedOut", "true");
		session.invalidate();
		session=request.getSession(true);
		//mv.addObject("logoutMessage","you have successfully logged out");
		//mv.addObject("loggedOut","true");
		return mv;
	}
	
	@ModelAttribute
	public User returnObject()
	{
		return new User(); 
	}
	 //After clicking submit this page with data is opened and is sent to addus page
	@RequestMapping(value = "/addus", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest request)

	{

		System.out.print(user.getCpassword());
		System.out.println(user.getPassword());

		user.setEnabled("true");
		user.setRole("ROLE_USER");

		if (user.getCpassword().equals(user.getPassword()));

		{

			userDAO.saveorUpdate(user);

		}

		return "Login";

	}
	
	

}


