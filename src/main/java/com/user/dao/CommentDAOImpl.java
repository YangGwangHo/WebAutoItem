package com.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.user.domain.Comment;
@Repository
public class CommentDAOImpl implements CommentDAO{
	
	private static final String namespace = "com.user.mappers.CommentMapper"; 
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<Comment> list(int b_idx,int start, int end){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("b_idx", b_idx);
		map.put("start",start);
		map.put("end",end);
		return sqlSession.selectList(namespace+".commentList",map);
	}
	@Override
	public void create(Comment comment) {
		sqlSession.insert(namespace+".commentInsert",comment);
		sqlSession.update(namespace+".commentCntUpdate",comment);
	}
	@Override
	public void update(Comment comment) {
		sqlSession.update(namespace+".commentUpdate",comment);
	}
	@Override
	public void delete(int c_idx,Comment comment) {
		sqlSession.delete(namespace+".commentDelete",c_idx);
		sqlSession.update(namespace+".commentCntUpdate",comment);
	}
	
	@Override
	public int count(int b_idx) {
		return sqlSession.selectOne(namespace+".commentCount",b_idx);
	}
	
	@Override
	public Comment detail(int c_idx) {
		return sqlSession.selectOne(namespace+".commentUpdateView",c_idx);
	}

}
