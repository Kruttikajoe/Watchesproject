package com.niit.watchesbackend.DAO;

import java.util.List;

import com.niit.watchesbackend.model.Supplier;

public interface SupplierDAO {
	public boolean saveorUpdate(Supplier supplier);
	public boolean delete(Supplier supplier);
	public Supplier get(int id);
	public List<Supplier> list();

}
