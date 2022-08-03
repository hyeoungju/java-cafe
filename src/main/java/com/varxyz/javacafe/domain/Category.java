package com.varxyz.javacafe.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Category {
	private long cId;
	private String cName;
	
	public Category() {
		
	}
	
	public Category(long cId) {
		this.cId = cId;
	}
}
