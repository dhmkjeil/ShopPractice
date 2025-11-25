package com.roch.shop.notice;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.ToString;

@Entity
@ToString
public class Notice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	
	@Column(nullable = false)
	public String title;
	
	@Column(nullable = false)
	public Date createDate;
}
