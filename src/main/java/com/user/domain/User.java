package com.user.domain;

public class User {
	private String id;
    private String pwd;
    private String name;
    private String email;
    private String phone;    
    private String sex;
    private String e_agree;
    private String s_agree;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getE_agree() {
		return e_agree;
	}
	public void setE_agree(String e_agree) {
		this.e_agree = e_agree;
	}
	public String getS_agree() {
		return s_agree;
	}
	public void setS_agree(String s_agree) {
		this.s_agree = s_agree;
	}
    
}
