package com.varxyz.javacafe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("javacafe.mainController")
@RequestMapping("/admin_main")
public class AdminMainController {
	
	@GetMapping
	public String login( HttpServletRequest request) {		
		return "admin_main";
	}
	
	
}
