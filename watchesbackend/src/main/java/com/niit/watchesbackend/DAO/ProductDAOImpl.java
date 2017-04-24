package com.niit.watchesbackend.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.watchesbackend.model.Product;
import com.niit.watchesbackend.model.User;

@Repository(value="productDAO")
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

	public boolean saveorUpdate(Product product) {
		Session s=sessionFactory.getCurrentSession();
		Transaction tx=s.beginTransaction();
		s.saveOrUpdate(product);
		tx.commit();
		return true;
	}
	
public boolean delete(Product product) {
		
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		System.out.println("deletion");
		s.delete(product);
		System.out.println("check");
		tx.commit();
		return true;
	}

}
