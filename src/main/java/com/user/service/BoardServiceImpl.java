package com.user.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dao.BoardDAO;
import com.user.domain.Board;

@Service
public class BoardServiceImpl implements BoardService  {
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<Board> selectBoardList(int start, int end, String searchOption, String keyword){		
		return boardDAO.selectBoardList(start,end,searchOption,keyword);
	}
	public int selectBoardListCnt(String searchOption, String keyword) {
		return boardDAO.selectBoardListCnt(searchOption,keyword);
	}
	
	@Override
	public void create(Board board,HttpSession session) {
		String title = board.getTitle();
		String contents = board.getContents();
		//태그 처리
		title = title.replace("<","&lt;");
		title = title.replace(">","&gt;");
		//공백 처리
		title = title.replace("    ","&nbsp;&nbsp;");
		//줄바꿈 처리
		contents = contents.replace("\n","<br>");
		board.setTitle(title);
		board.setContents(contents);
		board.setCreate_id(session.getAttribute("userId").toString());
		board.setCreate_name(session.getAttribute("userName").toString());
		boardDAO.create(board);
	}
	
	@Override
	public Board read(int idx) {
		return boardDAO.read(idx);
	}
	
	@Override
	public void update(Board board) {
		boardDAO.update(board);		
	}
	
	@Override
	public void delete(int idx) {
		boardDAO.delete(idx);
		
	}
	
	@Override
	public void increaseViewCnt(int idx) {
		boardDAO.increaseViewCnt(idx);
	}
}
