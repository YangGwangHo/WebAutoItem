package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dao.CommentDAO;
import com.user.domain.Comment;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentDAO commentDAO;
	
	@Override
	public List<Comment> list(int b_idx,int start, int end){
		return commentDAO.list(b_idx,start,end);
	}
	@Override
	public void create(Comment comment) {
		commentDAO.create(comment);
	}
	@Override
	public void update(Comment comment){
		commentDAO.update(comment);
	}
	@Override
	public void delete(int c_idx,Comment comment) {
		commentDAO.delete(c_idx, comment);
	}
	@Override
	public int count(int b_idx) {
		return commentDAO.count(b_idx);
	}
	
	@Override
	public Comment detail(int c_idx) {
		return commentDAO.detail(c_idx);
	}
	
}
