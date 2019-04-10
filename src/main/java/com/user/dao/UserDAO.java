package com.user.dao;

import com.user.domain.User;

public interface UserDAO {
	
	public int insertUser(User user);
	public int userIdCheck(String id);
	public User getUserInfo(String userId);
	public void userUpdate(User user);
}
