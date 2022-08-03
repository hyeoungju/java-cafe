package com.varxyz.javacafe.service;

import java.util.List;

import com.varxyz.javacafe.domain.MenuItem;

public interface MenuItemService {
	
	void addMenuItem(MenuItem menuItem); //관리자가 메뉴추가하기
	List<MenuItem> getMenuItem(String cName); //등록된 메뉴아이템 리스트 가져오기
	public String getCategoryName(long categoryId);
}
