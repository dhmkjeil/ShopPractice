package com.roch.shop;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@GetMapping("/")
	String hello() {
		return "index.html";
	}
	
	@GetMapping("/about")
	@ResponseBody
	String about() {
		return "연습용 웹페이지";
	}
}
