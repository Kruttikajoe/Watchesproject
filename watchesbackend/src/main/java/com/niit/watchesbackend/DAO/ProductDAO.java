package com.niit.watchesbackend.DAO;

import java.util.List;

import com.niit.watchesbackend.model.Product;

public interface ProductDAO {
public boolean saveorUpdate(Product product);
public boolean delete(Product product);
public Product get(int id);
public List<Product> list();
}
