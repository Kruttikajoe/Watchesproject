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

import com.niit.watchesbackend.model.Supplier;

@Repository(value = "supplierDAO")
@EnableTransactionManagement

public class SupplierDAOImpl implements SupplierDAO {

	@Autowired

	private SessionFactory sessionFactory;

	public SupplierDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveOrUpdate(Supplier supplier) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			return true;
			
		}catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	@Override
	@Transactional
	public boolean delete(Supplier supplier) {
		
		try{
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
			
		}catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}


	@Override
	@Transactional
	public Supplier get(int id) {
		try{
			return sessionFactory.getCurrentSession().createQuery("from Supplier where supid=:id", Supplier.class).setParameter("id", id).getSingleResult();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

	@Override
	@Transactional
	public List<Supplier> list() {
		try{
			return sessionFactory.getCurrentSession().createQuery("from Supplier", Supplier.class).getResultList();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	
	

}