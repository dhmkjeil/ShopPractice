package com.roch.shop;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	private Long id;
	private String name;
	private Integer age;
	
	public void addAgeOne() {
		this.age = age + 1;
	}
	
	public void setAge(Integer age) {
		if (age > 0 && age < 100) {
			this.age = age;
		}
	}
}