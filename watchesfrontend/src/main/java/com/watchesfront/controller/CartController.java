package com.watchesfront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.watchesbackend.DAO.CartDAO;
import com.niit.watchesbackend.model.Cart;
import com.niit.watchesbackend.model.Product;
import com.niit.watchesbackend.model.User;

@Controller

public class CartController {
	
	@Autowired
	
	private Cart cart;
	
	@Autowired

	private User user;
	
	@Autowired
	
	private CartDAO cartDAO;
	
	@ModelAttribute
	
    public Cart returnObject() {
		
		return new Cart();
	}
	
	@RequestMapping("/Cart")
	public String showDetails(Model mp) {
		return "Cart";
	}
	
	

}
