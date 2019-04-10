package com.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.user.domain.Comment;
import com.user.domain.CommentPage;
import com.user.service.CommentService;

@RestController
public class CommentController {
	@Autowired
	CommentService commentService;
	
	@RequestMapping("commentInsert.do")
	public void commentInsert(@ModelAttribute Comment comment,HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		String userName = (String) session.getAttribute("userName");
		comment.setCommentUserId(userId);
		comment.setCommentUserName(userName);
		
		commentService.create(comment);
	}
	
	@RequestMapping("commentList.do")
	public ModelAndView commentList(@RequestParam int b_idx,@RequestParam(defaultValue="1") int cursorPage,ModelAndView mv) {

		int count = commentService.count(b_idx);
		CommentPage commentPage = new CommentPage(count,cursorPage);
		int start = commentPage.getPageStart();
		int end = commentPage.getPageEnd();
		List<Comment> list = commentService.list(b_idx,start,end);
		mv.setViewName("board/commentList");
		mv.addObject("list",list);
		mv.addObject("commentPage",commentPage);
		
		return mv;
	}
	
	@RequestMapping("commentListJson.do")
	@ResponseBody
	public List<Comment> commentListJson(@RequestParam int b_idx,@RequestParam(defaultValue="1") int cursorPage) {
		int count = commentService.count(b_idx);
		CommentPage commentPage = new CommentPage(count,cursorPage);
		int start = commentPage.getPageStart();
		int end = commentPage.getPageEnd();
		List<Comment> list = commentService.list(b_idx,start,end);
			
		return list;
	}
	
	@RequestMapping("commentUpdateView.do")
	public ModelAndView commentUpdateView(@RequestParam int c_idx, ModelAndView mv) {		
		Comment comment = commentService.detail(c_idx);
		mv.setViewName("board/commentUpdateView");
		mv.addObject("comment",comment);
		return mv;
	}
	
	@RequestMapping("commentDelete.do")
	public void commentDelete(@RequestParam int b_idx,@RequestParam int c_idx){
		Comment comment = new Comment();
		comment.setB_idx(b_idx);
		commentService.delete(c_idx,comment);
	}
	
	@RequestMapping("commentUpdate.do")
	public void commentUpdate(@ModelAttribute Comment comment){
		commentService.update(comment);
	}
	
}
