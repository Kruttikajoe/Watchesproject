package com.watchesfront.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.watchesbackend.DAO.CategoryDAO;
import com.niit.watchesbackend.DAO.ProductDAO;
import com.niit.watchesbackend.DAO.SupplierDAO;
import com.niit.watchesbackend.model.Category;
import com.niit.watchesbackend.model.Product;
import com.niit.watchesbackend.model.Supplier;

@Controller

public class ProductController {
	
	@Autowired
	
	private ProductDAO productDAO;
	
	@Autowired
	
	private Product product;
	
@Autowired
	
	private SupplierDAO supplierDAO;
	
	@Autowired
	
	private Supplier supplier;
	
@Autowired
	
	private CategoryDAO categoryDAO;
	
	@Autowired
	
	private Category category;
	
	
	
	
@ModelAttribute
	
	public Product returnObject()
	{
		return new Product();
	}
	
	
	@RequestMapping("/AddProducts")
	public ModelAndView showProducts()
	{
		ModelAndView mv= new ModelAndView("AddProducts");
		mv.addObject("productList", productDAO.list());
		mv.addObject("categoryList",categoryDAO.list());
		mv.addObject("supplierList",supplierDAO.list());
		return mv;
	}
	
@RequestMapping(value="/addprod",method=RequestMethod.POST)
	
	public String addprod(@Valid @ModelAttribute("product")Product product, BindingResult result, Model model,HttpServletRequest request) throws IOException
	{
	model.addAttribute("product",new Product());
		if(product.getProdid()==0)
		{
			productDAO.saveorUpdate(product);
			System.out.println("product added");
		}
		else
		{
			productDAO.saveorUpdate(product);
			System.out.println("product updated");
		}
		return "redirect:/AddProducts";
	}
	
	
	@RequestMapping(value="/editproducts{id}")
	public ModelAndView updateProduct(@PathVariable("id")String id,Model model)
	{
	int i=Integer.parseInt(id);
	model.addAttribute("product", productDAO.get(i));
	model.addAttribute("productList", productDAO.list());
	ModelAndView mv=new ModelAndView("AddProducts");
	return mv;
	}
	
	
	@RequestMapping(value="/deleteproduct{id}")
	public ModelAndView deleteProduct(@PathVariable("id")String id,Model model)
	{
	int i=Integer.parseInt(id);
	product= productDAO.get(i);
	productDAO.delete(product);
	model.addAttribute("productList", productDAO.list());
	ModelAndView mv=new ModelAndView("AddProducts");
	mv.addObject("AddProducts", 0);
	return mv;
	}
	
	
	
	
	

}
