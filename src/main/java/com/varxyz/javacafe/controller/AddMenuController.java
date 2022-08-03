package com.varxyz.javacafe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.varxyz.javacafe.domain.MenuItem;
import com.varxyz.javacafe.service.MenuItemService;

@Controller("javacafe.addMenuItemController")
@RequestMapping("/menuItem/add_menuItem")
public class AddMenuController {
	
	@Autowired
	MenuItemService menuItemService;
	
	@GetMapping
	public String addMenuForm(Model model) {
		model.addAttribute("menuItem", new MenuItemCommand());
		return "menuItem/add_menuItem";
	}
	@GetMapping("/menuItem/test")
	public String testForm() {
		return "menuItem/add_menuItem";
	}
	
	@ModelAttribute("categoryProviderList")
	public List<CategoryProvider> getCategoryProviderList() {
		List<CategoryProvider> list = new ArrayList<CategoryProvider>();
		list.add(new CategoryProvider(2001, "커피"));
		list.add(new CategoryProvider(2002, "티"));
		list.add(new CategoryProvider(2003, "에이드&주스"));
		list.add(new CategoryProvider(2004, "스무디&프라페"));
		list.add(new CategoryProvider(2005, "디카페인"));
		
		return list;
	}
	
	@PostMapping
	public String addMenuItem(@ModelAttribute("menuItem")
				MenuItemCommand menuItemcommand, Model model) {

		model.addAttribute("menuItemCommand", menuItemcommand);
		MenuItem menuItem = new MenuItem();
		menuItem.setMenuName(menuItemcommand.getMenuName());
		menuItem.setMenuPrice(menuItemcommand.getMenuPrice());
		menuItem.setMenuImgUrl(menuItemcommand.getMenuImgUrl());
		menuItem.setMenuQuantity(menuItemcommand.getMenuQuantity());
		menuItem.setCategoryId(menuItemcommand.getCategoryId());
		menuItemService.addMenuItem(menuItem);
		
		return "menuItem/success_add_menuItem";
	}
}
