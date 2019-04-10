package com.user.service;

import javax.servlet.http.HttpSession;

import com.user.domain.User;

public interface LoginService {
	public boolean loginCheck(User user,HttpSession session);
	public User viewUser(User user);
	public void logout(HttpSession session);
}
