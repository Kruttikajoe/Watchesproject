package com.niit.watchesbackend.DAO;

import com.niit.watchesbackend.model.Cart;

public interface CartDAO {

	public boolean addCart(Cart cart);

	public boolean updateCart(Cart cart);

	public boolean resetCart(int id);

	Cart getCart(int id);
}
