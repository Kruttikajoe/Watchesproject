package com.niit.watchesbackend.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


import com.niit.watchesbackend.model.Product;
import com.niit.watchesbackend.model.User;

@Repository(value="productDAO")
//@EnableTransactionManagement

public class ProductDAOImpl implements ProductDAO {
	
	@Autowired

	private SessionFactory sessionFactory;

	public ProductDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public boolean saveorUpdate(Product product) {
		Session s=sessionFactory.openSession();
		Transaction tx=s.beginTransaction();
		s.saveOrUpdate(product);
		tx.commit();
		return true;
	}
	
public boolean delete(Product product) {
		
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		System.out.println("deletion");
		s.delete(product);
		System.out.println("check");
		tx.commit();
		return true;
	}

@Override
public Product get(int id) {
	String hql=" from Product where prodid="+id;
	Session s = sessionFactory.openSession();
	Transaction tx = s.beginTransaction();
	Query query=s.createQuery(hql);
	List<Product> list= query.list();
	tx.commit();
	if(list==null || list.isEmpty())
	{
		System.out.println("No products are available with this id"+id);
		return null;
	}
	else
	{
		return list.get(0);
	}
	
	
}

@Override
@Transactional
public List<Product> list() {
	Session s=sessionFactory.openSession();
	Transaction tx = s.beginTransaction();
	String hql="from Product";
	Query query=s.createQuery(hql);
	System.out.println("Starting of the method list");
	List<Product> list=query.list();
	if(list==null || list.isEmpty())
	{
		System.out.println("No products available");
	
	}
	
	tx.commit();
	return query.list();
	
	
}

}
