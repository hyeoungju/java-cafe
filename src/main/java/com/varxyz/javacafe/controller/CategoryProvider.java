package com.varxyz.javacafe.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CategoryProvider {
	private long cId;
	private String cName;
	
	public CategoryProvider(String cName) {
		this.cName = cName;
	}
}
