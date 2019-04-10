package com.user.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.user.domain.User;
import com.user.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    @RequestMapping(value="/join.do", method=RequestMethod.GET)
    public String signUp() {
        return "index";
    }
   
    @RequestMapping(value="/join.do", method=RequestMethod.POST)
    public String join(User user){	
    	userService.insertUser(user);
        return "index";
    }
    
    @ResponseBody       
    @RequestMapping(value="/userIdCheck.do", method=RequestMethod.POST)
    public void userIdCheck(HttpServletRequest req,HttpServletResponse response) {
    	String id = req.getParameter("ID");
    	int result = userService.userIdCheck(id);
    	String resultJson = "{\"result\":" + String.valueOf(result) + "}";
    	try {
        	response.getWriter().print(resultJson);    		
    	}catch(IOException e) {
    		e.printStackTrace();
    	}    	
    }  
	
	@RequestMapping(value = "/myroom.do", method = RequestMethod.GET)
	public ModelAndView myroom(HttpSession session) {		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("myroom");
		mv.addObject("user",userService.getUserInfo((String)session.getAttribute("userId")));		
		return mv;
	}	
	
	@RequestMapping(value="/userUpdate.do", method=RequestMethod.POST)
	public String userUpdate(User user,HttpSession session){
		user.setId((String)session.getAttribute("userId"));
		userService.userUpdate(user);
		return "index";
	}
    
    
}
