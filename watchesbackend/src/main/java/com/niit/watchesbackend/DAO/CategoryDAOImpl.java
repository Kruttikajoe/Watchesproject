package com.niit.watchesbackend.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.watchesbackend.model.Category;

@Repository(value = "categoryDAO")
@EnableTransactionManagement

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

	@Transactional
	public boolean saveOrUpdate(Category category) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
			
		}catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	@Transactional
	public boolean delete(Category category) {
		
		try{
			sessionFactory.getCurrentSession().delete(category);
			return true;
			
		}catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	@Override
	@Transactional
	public Category get(int id) {
		try{
			return sessionFactory.getCurrentSession().createQuery("from Category where categoryid=:id", Category.class).setParameter("id", id).getSingleResult();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

	@Override
	@Transactional
	public List<Category> list() {
		try{
			return sessionFactory.getCurrentSession().createQuery("from Category", Category.class).getResultList();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

		
}