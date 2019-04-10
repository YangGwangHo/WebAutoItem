package com.user.domain;

import java.util.Date;

public class Comment {
	private Integer c_idx;
	private Integer b_idx;
	private String commentText;
	private String commentUserId;
	private String commentUserName;
	private Date create_Date;
	private Date update_Date;
	public Date getCreate_Date() {
		return create_Date;
	}
	public void setCreate_Date(Date create_Date) {
		this.create_Date = create_Date;
	}
	public Date getUpdate_Date() {
		return update_Date;
	}
	public void setUpdate_Date(Date update_Date) {
		this.update_Date = update_Date;
	}
	public Integer getC_idx() {
		return c_idx;
	}
	public void setC_idx(Integer c_idx) {
		this.c_idx = c_idx;
	}
	public Integer getB_idx() {
		return b_idx;
	}
	public void setB_idx(Integer b_idx) {
		this.b_idx = b_idx;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public String getCommentUserId() {
		return commentUserId;
	}
	public void setCommentUserId(String commentUserId) {
		this.commentUserId = commentUserId;
	}
	public String getCommentUserName() {
		return commentUserName;
	}
	public void setCommentUserName(String commentUserName) {
		this.commentUserName = commentUserName;
	}

	
}
