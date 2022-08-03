package com.varxyz.javacafe.service;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.varxyz.javacafe.dao.MenuItemDao;
import com.varxyz.javacafe.domain.MenuItem;

public class MenuItemServiceImpl implements MenuItemService{
	
	@Autowired
	MenuItemDao menuItemDao;
	
	public MenuItemServiceImpl(DataSource dataSource) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public  void addMenuItem(MenuItem menuItem) {
		menuItemDao.addMenuItem(menuItem);
	}
	
	@Override
	public List<MenuItem> getMenuItem(String cName) {
		return null;
	}
	
}
