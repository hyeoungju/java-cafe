package com.varxyz.javacafe.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.varxyz.javacafe.domain.Cart;
import com.varxyz.javacafe.domain.MenuItem;
import com.varxyz.javacafe.service.CartServiceImpl;
import com.varxyz.javacafe.service.CategoryServiceImpl;
import com.varxyz.javacafe.service.MenuItemService;
import com.varxyz.javacafe.service.MenuItemServiceImpl;

@Controller("javacafe.viewMenuItemController")
public class ViewMenuItemListController {
	
	@Autowired
	MenuItemServiceImpl menuItemService;
	
	@Autowired
	CategoryServiceImpl cateService;
	
	@Autowired
	CartServiceImpl cartService;
	
	
	@GetMapping("/kiosk/view_menuItemList")
	public String mainkiosk(Model model) {
		List<MenuItem> menuItem = menuItemService.getMenuItem(2001);
		
		model.addAttribute("categoryList", cateService.getCategoryList());
		model.addAttribute("menuItem", menuItem);
		List<Cart> cartList = cartService.getCart();
		if (cartList.size() >= 1) {
			model.addAttribute("cartList", cartList);			
		}
		return "kiosk/view_menuItemList";
	}
	
	@RequestMapping(value = "/kiosk/requestObject", method = { RequestMethod.POST })
	@ResponseBody 
	public List<MenuItem> mainkiosk(@RequestBody MenuItemCommand menuItemCommand){
		List<MenuItem> menuItemList	= menuItemService.getMenuItem(menuItemCommand.getCategoryId());
		return menuItemList;
	 
	 }
	
	@RequestMapping(value = "/kiosk/requestForModal", method = { RequestMethod.POST })
	@ResponseBody
	public MenuItem getMenuItemForModal(@RequestBody MenuItemCommand menuItemCommand,
	      HttpServletRequest request) throws UnsupportedEncodingException{
		System.out.println(menuItemCommand.getMenuImgName());
	   MenuItem menuItem = menuItemService.getMenuItemBymenuName(menuItemCommand.getMenuImgName());
	   return menuItem;
	}
	
	
	@PostMapping("/kiosk/view_menuItemList")
	public String addCartForm(Cart cart, HttpServletRequest request) {
		int result = cartService.addCart(cart);
		System.out.println(result);
		if (result == 1 || result == 4) {
			return "redirect:/kiosk/view_menuItemList";
		}else {
			request.setAttribute("msg", "오류!");
			request.setAttribute("url", "view_menuItemList");
			return "alert";
			
		}
	}
	
}
