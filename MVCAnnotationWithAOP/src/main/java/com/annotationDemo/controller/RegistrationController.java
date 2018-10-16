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
import com.annotationDemo.service.RegistrationService;

@Controller
public class RegistrationController {
	
	@Autowired
	RegistrationService registrationService;

	@RequestMapping(method=RequestMethod.GET,value="/registration")
	public String showRegistration(){
		return "registration";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/registrationProcess")
	public ModelAndView registerUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("UserDTO") UserDTO userDTO){
		ModelAndView modelAndView = null;
		Integer userId = registrationService.addUser(userDTO);
			modelAndView = new ModelAndView("login");
			modelAndView.addObject("messager","Registration successfull");
		return modelAndView;
	}
}
