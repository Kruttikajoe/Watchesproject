package com.niit.watchesbackend.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.watchesbackend.model.Supplier;

@Repository(value="supplierDAO")

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

	public boolean saveorUpdate(Supplier supplier) {

		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.saveOrUpdate(supplier);
		tx.commit();
		return true;
	}
	
	public boolean delete(Supplier supplier) {

		try
		{
		
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		System.out.println("deletion");
		s.delete(supplier);
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

	public Supplier get(int id) {
		String hql=" from Supplier where supid="+id;
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Query query=s.createQuery(hql);
		List<Supplier> list= query.list();
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
	public List<Supplier> list() {
		Session s=sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		String hql="from Supplier";
		Query query=s.createQuery(hql);
		System.out.println("Starting of the method list");
		List<Supplier> list=query.list();
		if(list==null || list.isEmpty())
		{
			System.out.println("No suppliers available");
		
		}
		
		tx.commit();
		return query.list();
		
		
		
	}


}
