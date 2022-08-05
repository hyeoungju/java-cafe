package com.varxyz.javacafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
	
	
	public List<MenuItem> getMenuItem(){
		String sql = "SELECT m.mId, m.menuName, m.menuPrice, m.menuImgName, m.menuQuantity,"
				+ " FROM MenuItem m INNER JOIN Category c ON m.categoryId = c.cId"
				+ " WHERE c.cName=?";
		
		return jdbcTemplate.query(sql, new MenuItemRowMapper());
	}

	public List<MenuItem> getAllMenuItem(long categoryId) {
		String sql = "SELECT m.mId, m.menuName, m.menuPrice, m.menuImgName, m.menuQuantity"
				+ " FROM MenuItem m INNER JOIN Category c ON m.categoryId = c.cId"
				+ " WHERE m.categoryId=?";
		
		return jdbcTemplate.query(sql, new RowMapper<MenuItem>() {

			@Override
			public MenuItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				MenuItem menuItem = new MenuItem();
				menuItem.setMId(rs.getLong("mId"));
				menuItem.setMenuName(rs.getString("menuName"));
				menuItem.setMenuPrice(rs.getDouble("menuPrice"));
				menuItem.setMenuImgName(rs.getString("menuImgName"));
				menuItem.setMenuQuantity(rs.getInt("menuQuantity"));
				
				return menuItem;
			}
			
		}, categoryId);
	}

	public MenuItem getMenuItemBymenuName(String menuImgName) {
		String sql = "SELECT mId, categoryId, menuName, menuPrice, menuImgName FROM MenuItem WHERE menuImgName=?";
	      
	      return jdbcTemplate.queryForObject(sql, new RowMapper<MenuItem>() {

	         @Override
	         public MenuItem mapRow(ResultSet rs, int rowNum) throws SQLException {
	            MenuItem menuItem = new MenuItem();
	            menuItem.setMId(rs.getLong("mId"));
	            menuItem.setCategoryId(rs.getLong("categoryId"));
	            menuItem.setMenuName(rs.getString("menuName"));
	            menuItem.setMenuPrice(rs.getInt("menuPrice"));
	            menuItem.setMenuImgName(rs.getString("menuImgName"));
	            return menuItem;
	         }
	         
	      }, menuImgName);
	}


}
