package com.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String home2() {
		return "index";
	}	
	/*
	@RequestMapping(value = "/board.do", method = RequestMethod.GET)
	public String board() {
		return "board";
	}	
	*/
	@RequestMapping(value = "/about.do", method = RequestMethod.GET)
	public String about() {
		return "about";
	}	
	
	@RequestMapping(value = "/download.do", method = RequestMethod.GET)
	public String download() {
		return "download";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		return "login";
	}	
	
	@RequestMapping(value = "/signup.do", method = RequestMethod.GET)
	public String signup() {
		return "signup";
	}	
	
	
}
