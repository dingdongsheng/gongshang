package com.gongshang.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gongshang.model.User;

import  javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value="/demo")
//@RequestMapping("/")
public class IndexController {

	@RequestMapping(value="/index")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
	
		ModelAndView mav = new ModelAndView("velocity_main.vm");
		
		User user = new User();
		user.setNickname("hi");
		user.setState(1);
		
		List<User> list = new ArrayList<User>();
		for(int i=0; i<10; i++){
			User p = new User();
			p.setNickname(String.valueOf(i));
			p.setState(i);
			list.add(p);
			
		}
		
		mav.addObject("users", list);
		mav.addObject("user", user);
		// request scope data.
		request.setAttribute("requestData", "hangzhou");
		// Session scope data.
		request.getSession().setAttribute("sessionData", "123456");
		return mav;
	}
	
	@RequestMapping(value="/welcome")
	public ModelAndView helloVm(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("welcome.vm");
		modelAndView.addObject("message", "Hello, Velocity");
		return modelAndView;
	}
}
