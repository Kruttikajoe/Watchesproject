package com.niit.watchesbackend.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.watchesbackend.model.Product;

@Repository(value = "productDAO")
@EnableTransactionManagement

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

	@Override
	@Transactional
	public boolean saveOrUpdate(Product product) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		
	}
	
	@Override
	@Transactional
	public boolean delete(Product product) {
		try{
			sessionFactory.openSession().delete(product);
			return true;
			
		}catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	
	@Override
	@Transactional
	public Product get(int id) {
		try{
			return sessionFactory.getCurrentSession().createQuery("from Product where prodid=:id", Product.class).setParameter("id", id).getSingleResult();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

	@Override
	@Transactional
	public List<Product> list() {
		try{
			return sessionFactory.getCurrentSession().createQuery("from Product", Product.class).getResultList();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

}