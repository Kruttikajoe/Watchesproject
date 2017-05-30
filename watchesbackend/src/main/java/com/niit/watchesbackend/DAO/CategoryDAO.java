package com.niit.watchesbackend.DAO;

import java.util.List;

import com.niit.watchesbackend.model.Category;

public interface CategoryDAO {
	
	public boolean saveOrUpdate(Category category);

	public boolean delete(Category category);

	public Category get(int id);

	public List<Category> list();
}
