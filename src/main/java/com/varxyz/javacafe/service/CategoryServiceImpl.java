package com.varxyz.javacafe.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.varxyz.javacafe.dao.CategoryDao;
import com.varxyz.javacafe.domain.Category;

public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryDao categoryDao;
	
	
	@Override
	public  void addCategory(Category category) {
		categoryDao.addCategory(category);
	}

	@Override
	public List<Category> getCategoryList() {
		return categoryDao.getCategoryList();
	}
	
	
}
