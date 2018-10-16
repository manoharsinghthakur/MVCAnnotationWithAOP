package com.annotationDemo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.annotationDemo.model.UserDTO;
import com.annotationDemo.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;

	@RequestMapping(method=RequestMethod.GET,value="/login" )
	public ModelAndView showLogin(){
		String message="Please Enter Your Login Details";
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		modelAndView.addObject("message",message);
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/loginProcess")
	public ModelAndView validateUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("UserDTO") UserDTO userDTO){
		ModelAndView modelAndView = null;
		userDTO = loginService.validateUser(userDTO.getEmail(), userDTO.getPassword());
		if(userDTO != null){
			modelAndView = new ModelAndView("welcome");
			modelAndView.addObject("userName",userDTO.getUserName());
		}
		else{
			modelAndView = new ModelAndView("login");
			modelAndView.addObject("message1","user name or password is wrong !!");
		}
		return modelAndView;
	}
}
