package com.varxyz.javacafe.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Category {
	private long cid;
	private String name;
	
	public Category() {
		
	}
	
	public Category(long cid) {
		this.cid = cid;
	}
	
	

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", name=" + name + "]";
	}

	public Category(long cid, String name) {
		super();
		this.cid = cid;
		this.name = name;
	}
	
	
	
	
}
