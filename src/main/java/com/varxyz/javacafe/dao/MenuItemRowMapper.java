package com.varxyz.javacafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.varxyz.javacafe.domain.Category;
import com.varxyz.javacafe.domain.MenuItem;


public class MenuItemRowMapper implements RowMapper<MenuItem> {

	@Override
	public MenuItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		MenuItem menuItem = null;
		menuItem.setMId(rs.getLong("mId"));
		menuItem.setCategory(new Category(rs.getLong("categoryId")));
		menuItem.setMenuName(rs.getString("menuName"));
		menuItem.setMenuPrice(rs.getDouble("menuPrice"));
		menuItem.setMenuImgName(rs.getString("menuImgUrl"));
		menuItem.setMenuQuantity(rs.getInt("menuQuantity"));
		
		return menuItem;
	}


}
