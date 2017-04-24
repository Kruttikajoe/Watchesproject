package com.niit.watchesbackend.DAO;

import com.niit.watchesbackend.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Repository(value="userDAO")
@EnableTransactionManagement
public class UserDAOImpl implements UserDAO {
	@Autowired

	private SessionFactory sessionFactory;
	
	public UserDAOImpl()
	{
		super();
	}
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		super();
		this.sessionFactory=sessionFactory;
	}
	

	public boolean saveorUpdate(User user) {
		Session s=sessionFactory.getCurrentSession();
		Transaction tx=s.beginTransaction();
		s.saveOrUpdate(user);
		tx.commit();
		return true;
	}

	public boolean delete(User user) {
		
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		System.out.println("deletion");
		s.delete(user);
		System.out.println("check");
		tx.commit();
		return true;
	}

}
