package com.varxyz.javacafe.controller;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItemCommand {
	private long categoryId;
	private String menuName;
	private double menuPrice;
	private String menuImgUrl;
	private int menuQuantity;
}
