package com.user.dao;

import java.util.List;

import com.user.domain.Comment;

public interface CommentDAO {
	public List<Comment> list(int b_idx,int start, int end);
	public void create(Comment comment);
	public void update(Comment comment);
	public void delete(int c_idx,Comment comment);
	public int count(int b_idx);
	public Comment detail(int c_idx);
}
