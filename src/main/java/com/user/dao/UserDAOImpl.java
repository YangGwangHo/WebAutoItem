package com.user.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.user.domain.User;

@Repository("UserDAO")
public class UserDAOImpl implements UserDAO{
	
	@Autowired	
	private SqlSession sqlSession;
	
	private static final String namespace = "com.user.mappers.UserMapper"; 

	@Override
	public int insertUser(User user) {
		return sqlSession.insert(namespace+".insertUser",user);
	}
	
	@Override
	public int userIdCheck(String id){
		Map<String,Object> map = sqlSession.selectOne(namespace+".userIdCheck",id);
		int result = Integer.valueOf(String.valueOf(map.get("COUNT(*)")));
		return result;
	}
	
	@Override
	public User getUserInfo(String userId) {
		return sqlSession.selectOne(namespace+".getUserInfo",userId);
	}
	
	@Override
	public void userUpdate(User user) {
		sqlSession.update(namespace+".userUpdate",user);
	}
	
}
