package com.niit.watchesbackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.watchesbackend.DAO.ProductDAO;
import com.niit.watchesbackend.model.Product;

public class ProductTestCase {
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static ProductDAO productDAO; 
	
	@Autowired
	static Product product;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("productDAO");
		product=(Product)context.getBean("product");
	}

	@Test
	public void test() {
		product.setPrice(20000);
		product.setQty(2);
		product.setWeight(2);
		product.setProdname("rado");
		boolean b=productDAO.saveorUpdate(product);
		assertEquals("saved",true,b);
	}

}
