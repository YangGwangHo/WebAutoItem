package com.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.user.domain.Board;
import com.user.domain.BoardPage;
import com.user.domain.CommentPage;
import com.user.service.BoardService;
import com.user.service.CommentService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@Autowired
	private CommentService commentService;
	
	// 게시글 목록
	@RequestMapping(value="/board.do")
	public ModelAndView boardList(@RequestParam(defaultValue="all") String searchOption,@RequestParam(defaultValue="") String keyword,@RequestParam(defaultValue="1") int cursorPage) throws Exception{
		int count = boardService.selectBoardListCnt(searchOption,keyword);
		
		BoardPage boardPage = new BoardPage(count,cursorPage);
		int start = boardPage.getPageStart();
		int end = boardPage.getPageEnd();
		
		List<Board> list = boardService.selectBoardList(start,end,searchOption,keyword);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list",list);
		map.put("count",count);
		map.put("searchOption",searchOption);
		map.put("keyword",keyword);
		map.put("boardPage",boardPage);
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board");
		mv.addObject("map",map);
		return mv;
	}
	
	//게시글 작성화면
	@RequestMapping(value="write.do", method=RequestMethod.GET)
	public String write() {
		return "board/write";
	}
	
	//게시글 작성처리
	@RequestMapping(value="insert.do", method=RequestMethod.POST)
	public String insert(@ModelAttribute Board board,HttpSession session) throws Exception{
		boardService.create(board,session);
		return "redirect:board.do";
	}
	
	//게시글 상세조회
	@RequestMapping(value="detail.do", method=RequestMethod.GET)
	public ModelAndView view(@RequestParam int idx) throws Exception{
		boardService.increaseViewCnt(idx);		
		ModelAndView mv = new ModelAndView();
		int count = commentService.count(idx);
		CommentPage commentPage = new CommentPage(count,1);
		mv.setViewName("board/detail");
		mv.addObject("detail",boardService.read(idx));
		mv.addObject("commentPage",commentPage);		
		return mv;
	}
	
	@RequestMapping(value="update.do", method=RequestMethod.GET)
	public ModelAndView update(@RequestParam int idx, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/update");
		mv.addObject("update",boardService.read(idx));
		return mv;		
	}
	
	@RequestMapping(value="update.do", method=RequestMethod.POST)
	public String updatePost(@ModelAttribute Board board) throws Exception{
		boardService.update(board);
		return "redirect:board.do";
	}
	
	@RequestMapping(value="delete.do",method=RequestMethod.GET)
	public String delete(@RequestParam int idx) throws Exception{
		boardService.delete(idx);
		return "redirect:board.do";
	}
	
}
