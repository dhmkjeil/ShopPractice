package com.roch.shop;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@ToString
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private Integer price;
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setPrice(Integer price) {
		if (price > 0) {
			this.price = price;
		} else {
			this.price = 0;
		}
	}
}