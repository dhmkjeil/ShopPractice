package com.roch.shop.item;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		itemService.saveItem(0L, title, price);
		return "redirect:/list";
	}
	
	@PostMapping("/save")
	String saveItem(@RequestParam("id") Long id, @RequestParam("title") String title, 
			@RequestParam(value = "price", required = false) String price) {
		itemService.saveItem(id, title, price);
		return "redirect:/list";
	}

	@GetMapping("/detail/{id}")
	String detail(Model model, @PathVariable("id") Long id) {
		itemService.itemDetail(model, id);
		return "detail.html";
	}
	
	@GetMapping("/edit/{id}")
	String fix(Model model, @PathVariable("id") Long id) {
		itemService.itemFix(model, id);
		return "itemEdit.html";
	}
	
	@DeleteMapping("/delete")
	ResponseEntity<String> deleteItem(@RequestParam("id") Long id) {
		itemRepository.deleteById(id);
		return ResponseEntity.status(200).body("삭제완료");
	}
}