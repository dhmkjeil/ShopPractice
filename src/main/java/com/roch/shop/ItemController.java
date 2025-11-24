package com.roch.shop;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ItemController {

	private final ItemRepository itemRepository;
	private final ItemService itemService;

	@GetMapping("/list")
	String itemList(Model model) {
		itemService.findAllItem(model);
		return "itemList.html";
	}

	@GetMapping("/write")
	String write() {
		return "write.html";
	}

	@PostMapping("/add")
	String addItem(@RequestParam("title") String title, @RequestParam(value = "price", required = false) String price) {
		itemService.saveItem(title, price);
		return "redirect:/list";
	}

	@GetMapping("/detail/{id}")
	String detail(Model model, @PathVariable("id") Long id) {
		itemService.itemDetail(model, id);
		return "detail.html";
	}
}