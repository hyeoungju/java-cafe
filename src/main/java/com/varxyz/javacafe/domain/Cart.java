package com.varxyz.javacafe.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {
	private	long cartId;
	private int purchaseQuantity;
	private String menuItemName;
	private String menuImgName;
	private double menuPrice;
}
