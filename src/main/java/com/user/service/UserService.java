package com.user.service;

import com.user.domain.User;

public interface UserService {
    public int insertUser(User user);
    public int userIdCheck(String id);
	public User getUserInfo(String userId);
	public void userUpdate(User user);
}
