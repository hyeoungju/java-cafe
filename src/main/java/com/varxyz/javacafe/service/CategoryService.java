package com.varxyz.javacafe.service;

import java.util.List;

import com.varxyz.javacafe.domain.Category;

public interface CategoryService {
	
	void addCategory(Category category);
	List<Category> getCategoryList();
}
