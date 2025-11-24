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
	
	@GetMapping("/list")
	String itemList(Model model) {
		
		User u = new User();
		u.setName("김철수");
		u.setAge(21);
		u.addAgeOne();
		
		List<Item> result = itemRepository.findAll();
		model.addAttribute("items", result);
		return "itemList.html";
	}
	
	@GetMapping("/write")
	String write() {
		return "write.html";
	}
	
	@PostMapping("/add")
	String addItem(@RequestParam("title") String title, @RequestParam(value="price", required=false) Integer price) {
		if (title != "" && price != null) {
			Item item = new Item();
			item.setTitle(title);
			item.setPrice(price);
				
			itemRepository.save(item);
			return "redirect:/list";
		} else {
			return "write";
		}
	}
	
	@GetMapping("/detail/{id}")
	String detail(Model model, @PathVariable("id") Long id){
		Optional<Item> result = itemRepository.findById(id);
		if (result.isPresent()) {
			model.addAttribute("detail", result.get());
			return "detail.html";
		} else {
			return "redirect:/list";
		}
	}
}