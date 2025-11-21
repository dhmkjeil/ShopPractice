package com.roch.shop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {
	@GetMapping("/list")
	String itemList(Model model) {
		model.addAttribute("name", "Kim");
		return "itemList.html";
	}
}
