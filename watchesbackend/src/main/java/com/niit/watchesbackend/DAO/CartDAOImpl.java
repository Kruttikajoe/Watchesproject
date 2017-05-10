package com.niit.watchesbackend.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.watchesbackend.model.Cart;
@Repository("cartDAO")
@Transactional

public class CartDAOImpl implements CartDAO {
	@Autowired
	private SessionFactory sessionFactory;
	

	public CartDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public CartDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addCart(Cart cart) {
		Session s=sessionFactory.openSession();
		Transaction tx=s.beginTransaction();
		s.save(cart);
		tx.commit();
		return false;
	}

	@Override
	public boolean updateCart(Cart cart) {
		try
		{
			Session session;
			System.out.println("updating cart with id"+cart.getCartid());
			Session s=sessionFactory.openSession();
			Transaction tx=s.beginTransaction();
			s.update(cart);
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
	public boolean resetCart(int id) {
		System.out.println("cart id"+id);
		Query q=sessionFactory.openSession().createQuery("update Cart set grandtotal=:total, qty=:quan where cartid=:id");
		q.setParameter("total", 0.0f);
		q.setParameter("quan", 0);
		q.setParameter("id", id);
		int i=q.executeUpdate();
		System.out.println("updated cart i value"+i);
		return false;
	}

	@Override
	public Cart getCart(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
