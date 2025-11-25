package com.roch.shop.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false)
	private String displayName;
	
	@Column(nullable = false)
	private String password;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}