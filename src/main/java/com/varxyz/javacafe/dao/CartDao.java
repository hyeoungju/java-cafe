package com.varxyz.javacafe.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.varxyz.javacafe.domain.Cart;

public class CartDao {

private JdbcTemplate jdbcTemplate;
	
	public CartDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int addCart(Cart cart) {
		String sql = "INSERT INTO Cart (purchaseQuantity, menuItemName, menuImgName, menuPrice)"
				+ " VALUES (?,?,?,?)";
		try {
			jdbcTemplate.update(sql,cart.getPurchaseQuantity(), cart.getMenuItemName(), cart.getMenuImgName(), cart.getMenuPrice());
			return 1;
		} catch (Exception e) {
			System.out.println(e);
			return 2;
		}
	}

	public Cart checkCart(Cart cart) {
		try {
			String sql = "SELECT * FROM Cart WHERE MenuItemName = ?";
			return jdbcTemplate.queryForObject(sql, new RowMapper<Cart>() {

				@Override
				public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
					Cart cart = new Cart();
					cart.setCartId(rs.getLong("cartId"));
					cart.setPurchaseQuantity(rs.getInt("purchaseQuantity"));
					cart.setMenuItemName(rs.getString("menuItemName"));
					cart.setMenuImgName(rs.getString("menuImgName"));
					cart.setMenuPrice(rs.getDouble("menuPrice"));
					return cart;
				}
				
			}, cart.getMenuItemName());
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * 
	 * @param cart
	 * @return
	 */
	public int updateCart(Cart cart) {
		String sql = "UPDATE Cart SET purchaseQuantity = purchaseQuantity + ? WHERE menuItemName = ?";
		
		try {
			jdbcTemplate.update(sql, cart.getPurchaseQuantity(), cart.getMenuItemName());
			return 4;
		} catch (Exception e) {
			System.out.println(e);
			return 2;
		}
		
	}

	public List<Cart> getCart() {
		try {
			String sql = "SELECT * FROM Cart";
			return jdbcTemplate.query(sql, new RowMapper<Cart>() {

				@Override
				public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
					Cart cart = new Cart();
					cart.setCartId(rs.getLong("cartId"));
					cart.setPurchaseQuantity(rs.getInt("purchaseQuantity"));
					cart.setMenuItemName(rs.getString("menuItemName"));
					cart.setMenuImgName(rs.getString("menuImgName"));
					cart.setMenuPrice(rs.getDouble("menuPrice"));
					return cart;
				}
				
			});
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
