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
		String sql = "INSERT INTO MenuItem (categoryId, menuName, menuPrice, menuImgUrl, menuQuantity)"
				+ " VALUES(?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql,menuItem.getCategoryId(), menuItem.getMenuName(), menuItem.getMenuPrice(),
				menuItem.getMenuImgUrl(), menuItem.getMenuQuantity());
	}
	
	public List<MenuItem> getMenuItem(String cName){
		String sql = "SELECT m.mId, m.menuName, m.menuPrice, m.menuImgUrl, m.menuQuantity,"
				+ " FROM MenuItem m INNER JOIN Category c ON m.categoryId = c.cId"
				+ " WHERE c.cName=?";
		
		return jdbcTemplate.query(sql, new MenuItemRowMapper(), cName);
	}

}
