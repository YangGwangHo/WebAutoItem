package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dao.UserDAO;
import com.user.domain.User;

@Service
public class UserServiceImpl implements UserService{
	
    @Autowired
    private UserDAO dao;
      
    @Override
    public int insertUser(User user) {
        return dao.insertUser(user);
    }
    
    
	@Override
	public int userIdCheck(String id) {
		return dao.userIdCheck(id);
	}
	
	@Override
	public User getUserInfo(String userId) {
		return dao.getUserInfo(userId);
	}
	
	@Override
	public void userUpdate(User user) {
		dao.userUpdate(user);
	}
}
