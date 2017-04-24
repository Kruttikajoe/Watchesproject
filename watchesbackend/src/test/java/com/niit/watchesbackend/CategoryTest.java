package com.niit.watchesbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.watchesbackend.DAO.CategoryDAO;
import com.niit.watchesbackend.model.Category;

public class CategoryTest {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		context.getBean("category");
		
		CategoryDAO categoryDAO= (CategoryDAO)context.getBean("categoryDAO");
		Category category=(Category)context.getBean("category");
		category.setCategoryname("Rado");
		category.setCdescription("Rado watches");
		//categoryDAO.saveorUpdate(category);
		//System.out.println("category created");
		categoryDAO.delete(category);
		System.out.println("category deleted");

}
}
