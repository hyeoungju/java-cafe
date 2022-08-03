package com.varxyz.javacafe.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MenuItem {
	private long mId;
	private long categoryId;
	private Category category;
	private String menuName;
	private double menuPrice;
	private String menuImgName;
	private int menuQuantity;
	private Date regDate;
	
	public MenuItem() {
		
	}

	public void setCategory(Category category) {
		// TODO Auto-generated method stub
		
	}
}
