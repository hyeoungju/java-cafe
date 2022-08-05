package com.varxyz.javacafe.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.varxyz.javacafe.domain.MenuItem;
import com.varxyz.javacafe.service.CategoryServiceImpl;
import com.varxyz.javacafe.service.MenuItemService;

@Controller("javacafe.addMenuItemController")
@RequestMapping("/menuItem/add_menuItem")
public class AddMenuController {
	
	@Autowired
	MenuItemService menuItemService;
	
	@Autowired
	CategoryServiceImpl cateService;
	
	@GetMapping
	public String addMenuForm(Model model) {
		model.addAttribute("menuItem", new MenuItemCommand());
		model.addAttribute("categoryList", cateService.getCategoryList());
		return "menuItem/add_menuItem";
	}
	
//	List<CategoryProvider> list = new ArrayList<CategoryProvider>();
	
	/*
	 * @ModelAttribute("categoryProviderList") public List<CategoryProvider>
	 * getCategoryProviderList() { List<CategoryProvider> list =
	 * cateService.getCategoryList(); return list; }
	 */
	
	@PostMapping
	public String addMenuItem(@ModelAttribute("menuItem")
				MenuItemCommand menuItemcommand, Model model, HttpServletRequest request, @RequestParam("file") MultipartFile menuImgName) throws IllegalStateException, IOException {
		
		String filePath = "C:\\NCS\\back\\eclipse\\workspace\\java-cafe\\src\\main\\webapp\\resources\\menuImg\\";
		//파일명
		String originalFile = menuImgName.getOriginalFilename();
		System.out.println(originalFile);
		//파일명 중 확장자만 추출
		String originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
		String storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
		
		File file = new File(filePath + storedFileName);
		menuImgName.transferTo(file);
		
		model.addAttribute("menuItemCommand", menuItemcommand);
		MenuItem menuItem = new MenuItem();
		menuItem.setCategoryId(menuItemcommand.getCategoryId());
		menuItem.setMenuName(menuItemcommand.getMenuName());
		menuItem.setMenuPrice(menuItemcommand.getMenuPrice());
		menuItem.setMenuImgName(storedFileName);
		menuItem.setMenuQuantity(menuItemcommand.getMenuQuantity());
		menuItemService.addMenuItem(menuItem);
		
		String categoryName = menuItemService.getCategoryName(menuItemcommand.getCategoryId());
		
		request.setAttribute("categoryName", categoryName);
		
		
		return "menuItem/success_add_menuItem";
	}
}
