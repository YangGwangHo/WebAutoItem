package com.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.user.domain.Board;

@Repository
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	SqlSession sqlSession;
	
	private static final String namespace = "com.user.mappers.BoardMapper"; 
	
	@Override
	public List<Board> selectBoardList(int start, int end, String searchOption, String keyword){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start",start);
		map.put("end",end);
		map.put("searchOption",searchOption);
		map.put("keyword",keyword);
		return sqlSession.selectList(namespace+".selectBoardList",map);	
	}
	
	public int selectBoardListCnt(String searchOption, String keyword) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("searchOption",searchOption);
		map.put("keyword",keyword);
		return sqlSession.selectOne(namespace+".selectBoardListCnt",map);	
	}
	
	@Override
	public void create(Board board) {
		sqlSession.insert(namespace+".insert",board);
	}
	
	@Override
	public Board read(int idx) {
		return sqlSession.selectOne(namespace+".view",idx);
	}
	
	@Override
	public void update(Board board) {
		sqlSession.update(namespace+".update",board);
	}
	
	@Override
	public void delete(int idx) {
		sqlSession.delete(namespace+".delete",idx);
		
	}
	
	@Override
	public void increaseViewCnt(int idx) {
		sqlSession.update(namespace+".increaseViewCnt",idx);
	}
}
