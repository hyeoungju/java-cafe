package com.varxyz.javacafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.varxyz.javacafe.service.CategoryServiceImpl;
import com.varxyz.javacafe.service.MenuItemService;

@Controller("javacafe.viewMenuItemController")
@RequestMapping("/kiosk/view_menuItemList")
public class ViewMenuItemListController {
	
	@Autowired
	MenuItemService menuItemService;
	
	@Autowired
	CategoryServiceImpl cateService;
	
	@GetMapping
	public String addMenuForm(Model model) {
		
		return "kiosk/view_menuItemList";
	}
}
