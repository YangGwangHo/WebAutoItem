package com.user.dao;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.user.domain.User;

@Repository("LoginDAO")
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.user.mappers.LoginMapper"; 
	
	@Override
	public boolean loginCheck(User user) {
		String name = sqlSession.selectOne(namespace +".loginCheck",user);
		boolean result;
		if(name == null)
			result = false;
		else
			result = true;
		return result;
	}
	
	@Override
	public User viewMember(User user) {
		return sqlSession.selectOne(namespace+".viewMember",user);
	}
	
	@Override
	public void logout(HttpSession session) {		
	}
}
