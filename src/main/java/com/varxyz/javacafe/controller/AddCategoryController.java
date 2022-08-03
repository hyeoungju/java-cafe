package com.varxyz.javacafe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.varxyz.javacafe.domain.Category;
import com.varxyz.javacafe.service.CategoryServiceImpl;

@Controller("javacafe.addCategoryController")
@RequestMapping("/menuItem/add_category")
public class AddCategoryController {
	
	@Autowired
	CategoryServiceImpl categoryService;
	
	@GetMapping
	public String addCategoryForm(Model model) {
		model.addAttribute("Category", new Category());
		return "menuItem/add_category";
	}
	
	@PostMapping
	public String addCategory(@ModelAttribute("category") Category category, Model model) {
		
		categoryService.addCategory(category);
		model.addAttribute("category", category);
		return "menuItem/success_add_category";
	}
	
}
