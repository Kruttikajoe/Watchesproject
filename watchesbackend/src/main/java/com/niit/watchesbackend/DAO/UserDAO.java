package com.niit.watchesbackend.DAO;

import java.util.List;

import com.niit.watchesbackend.model.User;

public interface UserDAO {

	public boolean saveOrUpdate(User user);

	public boolean delete(User user);

	public User get(String email);

	public List<User> list();

}
