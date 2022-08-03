package com.varxyz.javacafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.varxyz.javacafe.controller.CategoryProvider;
import com.varxyz.javacafe.domain.Category;

public class CategoryDao {
	private JdbcTemplate jdbcTemplate;
	
	public CategoryDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void addCategory(Category category) {
		String sql = "INSERT INTO Category (cName) VALUES(?)";
		jdbcTemplate.update(sql, category.getCName());
	}
	
	public List<CategoryProvider> getCategoryName() {
		String sql = "SELECT * FROM Category ";
		return jdbcTemplate.query(sql, new RowMapper<CategoryProvider>() {
			
			@Override
			public CategoryProvider mapRow(ResultSet rs, int rowNum) throws SQLException {
				CategoryProvider c = new CategoryProvider(rs.getLong("cId"), rs.getString("cName"));
				return c;
			}
		});
	}
}
