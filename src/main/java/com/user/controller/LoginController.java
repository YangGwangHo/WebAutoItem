package com.user.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.user.domain.User;
import com.user.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/loginPost.do", method=RequestMethod.POST)
    public ModelAndView loginForm(@ModelAttribute User user, HttpSession session,HttpServletResponse response) throws Exception {    

		boolean result = loginService.loginCheck(user,session);

        ModelAndView mv = new ModelAndView();
        if(result == true) {
        	mv.setViewName("index");
        }
        else{
        	response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.println("<script>alert('아이디 또는 비밀번호가 틀렸습니다.');</script>");
            writer.flush();
        	mv.setViewName("login");
        }        
        return mv;
    }
	
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session) throws Exception{
		loginService.logout(session);
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

}
