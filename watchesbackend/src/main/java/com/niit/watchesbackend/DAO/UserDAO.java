package com.niit.watchesbackend.DAO;

import com.niit.watchesbackend.model.User;

public interface UserDAO {
	public boolean saveorUpdate(User user);
	public boolean delete(User user);
	public User get(String id);


}
