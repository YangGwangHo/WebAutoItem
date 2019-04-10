package com.user.dao;

import javax.servlet.http.HttpSession;

import com.user.domain.User;

public interface LoginDAO {
	public boolean loginCheck(User user);
	public User viewMember(User user);
	public void logout(HttpSession session);
	
}
