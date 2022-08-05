package com.varxyz.javacafe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.javacafe.domain.Cart;
import com.varxyz.javacafe.service.CartServiceImpl;
import com.varxyz.javacafe.service.MenuItemServiceImpl;

@Controller
public class AddCartController {
	
	@Autowired
	MenuItemServiceImpl menuItemService;
	
	@Autowired
	CartServiceImpl cartService;
	
	
	
	
	
}
