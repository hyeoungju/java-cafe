package com.varxyz.javacafe.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.javacafe.domain.MenuItem;

public class MenuItemDao {
	private JdbcTemplate jdbcTemplate;
	
	public MenuItemDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void addMenuItem(MenuItem menuItem) {
		String sql = "INSERT INTO MenuItem (categoryId, menuName, menuPrice, menuImgName, menuQuantity)"
				+ " VALUES(?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql,menuItem.getCategoryId(), menuItem.getMenuName(), menuItem.getMenuPrice(),
				menuItem.getMenuImgName(), menuItem.getMenuQuantity());
	}
	
	public String getCategoryName(long categoryId) {
		String sql = "SELECT cName FROM Category WHERE cId = ?";
		return jdbcTemplate.queryForObject(sql, String.class, categoryId);
				
	}
	
	public List<MenuItem> getMenuItem(String cName){
		String sql = "SELECT m.mId, m.menuName, m.menuPrice, m.menuImgName, m.menuQuantity,"
				+ " FROM MenuItem m INNER JOIN Category c ON m.categoryId = c.cId"
				+ " WHERE c.cName=?";
		
		return jdbcTemplate.query(sql, new MenuItemRowMapper(), cName);
	}

}
