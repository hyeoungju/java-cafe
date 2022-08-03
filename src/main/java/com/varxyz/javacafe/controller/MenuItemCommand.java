package com.varxyz.javacafe.controller;



import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItemCommand {
	private long categoryId;
	private String menuName;
	private double menuPrice;
	private String menuImgName;
	private MultipartFile file;
	private int menuQuantity;
}
