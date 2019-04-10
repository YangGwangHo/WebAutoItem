package com.user.dao;

import java.util.List;

import com.user.domain.Board;

public interface BoardDAO {
	public List<Board> selectBoardList(int start, int end, String searchOption, String keyword);
	public int selectBoardListCnt(String searchOption, String keyword);
	public void create(Board board);
	public Board read(int idx);
	public void update(Board board);
	public void delete(int idx);
	public void increaseViewCnt(int idx);
}
