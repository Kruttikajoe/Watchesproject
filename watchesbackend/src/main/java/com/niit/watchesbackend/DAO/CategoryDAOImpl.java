package com.niit.watchesbackend.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.watchesbackend.model.Category;

@Repository(value="categoryDAO")

public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDAOImpl() {
		super();
		
	}

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public boolean saveorUpdate(Category category) {

		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.saveOrUpdate(category);
		tx.commit();
		return true;
	}
	

	public boolean delete(Category category) {

		try
		{
		
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		System.out.println("deletion");
		s.delete(category);
		System.out.println("check");
		tx.commit();
		return true;
		}
		
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		
		
	} 
	
	@Override

	public Category get(int id) {
		String hql=" from Category where categoryid="+id;
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Query query=s.createQuery(hql);
		List<Category> list= query.list();
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
	public List<Category> list() {
		Session s=sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		String hql="from Category";
		Query query=s.createQuery(hql);
		System.out.println("Starting of the method list");
		List<Category> list=query.list();
		if(list==null || list.isEmpty())
		{
			System.out.println("No categories available");
		
		}
		
		tx.commit();
		return query.list();
		
		
		
	}

}
