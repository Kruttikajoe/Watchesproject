package com.niit.watchesbackend.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.watchesbackend.model.CartItem;

@Repository("cartitemDAO")
@Transactional

public class CartItemDAOImpl implements CartItemDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addCartItem(CartItem cartItem) {
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.save(cartItem);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	}

	@Override
	public List<CartItem> getAll(int id) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		Query query = s.createQuery("FROM CartItem where cart_cartid=:id");
		query.setParameter("id", id);
		tx.commit();
		return query.list();
	}

	@Override
	public boolean deleteCartItem(CartItem cartItem) {
		try {
			sessionFactory.openSession().delete(cartItem);
			return true;

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public CartItem getCartItem(int id) {
		return (CartItem) sessionFactory.openSession().get(CartItem.class, id);
	}

	@Override
	public boolean deleteAll(int cart_id) {
		try {
			Query q = sessionFactory.openSession().createQuery("delete from CartItem where cart_cartid=:id");
			q.setParameter("id", cart_id);
			q.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

	@Override
	public CartItem getExistingCartItemCount(int productid, int cart_id) {
		Query q = sessionFactory.openSession()
				.createQuery("from CartItem where cart_cartid=:cartid and product_prodid=:productid");
		q.setParameter("cartid", cart_id);
		q.setParameter("productid", productid);

		try {

			return (CartItem) q.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateCartItem(CartItem cartItem) {
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.update(cartItem);
			tx.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	}

}
