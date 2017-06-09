package com.niit.watchesbackend.DAO;

import com.niit.watchesbackend.model.User;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "userDAO")
@EnableTransactionManagement

public class UserDAOImpl implements UserDAO {
	@Autowired

	private SessionFactory sessionFactory;

	public UserDAOImpl() {
		super();
	}

	public UserDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveOrUpdate(User user) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return  true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}	
	}
	
	@Transactional
	public boolean delete(User user) {
		try{
			sessionFactory.getCurrentSession().delete(user);
			return  true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}	
	}
	
	@Override
	@Transactional
	public User get(String email) {
		try{
			
			return sessionFactory.getCurrentSession().createQuery("from User where emailid=:email", User.class).setParameter("email", email).getSingleResult();
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in get method of userDAO");
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	@Transactional
	public List<User> list() {
		try{
			return sessionFactory.getCurrentSession().createQuery("from User", User.class).getResultList();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
}