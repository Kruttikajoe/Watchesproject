package com.niit.watchesbackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.watchesbackend.DAO.CategoryDAO;
import com.niit.watchesbackend.model.Category;



public class CategoryTestCase {
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static CategoryDAO categoryDAO; 
	
	@Autowired
	static Category category;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		category=(Category)context.getBean("category");
	}

	@Test
	public void test() {
		category.setCategoryname("rado watches");
		category.setCdescription("watches");
		boolean b=categoryDAO.saveOrUpdate(category);
		assertEquals("saved",true,b);
	}

}
