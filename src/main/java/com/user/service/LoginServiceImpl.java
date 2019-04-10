package com.user.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dao.LoginDAO;
import com.user.domain.User;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO loginDAO;
	
	@Override
	public boolean loginCheck(User user, HttpSession session) {
		boolean result = loginDAO.loginCheck(user);
		if(result) {
			User user2 = viewUser(user);
			session.setAttribute("userId", user2.getId());
			session.setAttribute("userName", user2.getName());
		}
		return result;
	}
	
	@Override
	public User viewUser(User user) {
		return loginDAO.viewMember(user);
	}
	
	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}
	
}
