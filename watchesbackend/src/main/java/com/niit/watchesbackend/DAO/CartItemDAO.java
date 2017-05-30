package com.niit.watchesbackend.DAO;

import java.util.List;

import com.niit.watchesbackend.model.CartItem;

public interface CartItemDAO {
	public boolean addCartItem(CartItem cartItem);
	public List<CartItem> getAll(int id);
	public boolean deleteCartItem(CartItem cartItem);
	public CartItem getCartItem(int id);
	public boolean deleteAll(int cart_id);
	public CartItem getExistingCartItemCount(int product_id, int cart_id);
	public boolean updateCartItem(CartItem cartItem);

}
