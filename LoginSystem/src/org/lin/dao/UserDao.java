package org.lin.dao;

import org.lin.entity.User;

public interface UserDao {
	
	public User findByUserName(String username);
}
