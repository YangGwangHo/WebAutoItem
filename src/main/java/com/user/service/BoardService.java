package com.user.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.user.domain.Board;

public interface BoardService {
	public List<Board> selectBoardList(int start, int end, String searchOption, String keyword);
	public int selectBoardListCnt(String searchOption, String keyword);
	public void create(Board board,HttpSession session);
	public Board read(int idx);
	public void update(Board board);
	public void delete(int idx);
	public void increaseViewCnt(int idx);
	
}
