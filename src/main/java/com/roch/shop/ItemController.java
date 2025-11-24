package com.roch.shop;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		System.out.println(u.getName());
		System.out.println(u.getAge());
		
		u.addAgeOne();
		System.out.println(u.getAge());
		
		List<Item> result = itemRepository.findAll();
		model.addAttribute("items", result);
		System.out.println(result.toString());
		return "itemList.html";
	}
	
	@GetMapping("/write")
	String write() {
		return "write.html";
	}
	
	@PostMapping("/addItem")
	String addItem(@RequestParam(name="title") String title, @RequestParam(name="price") Integer price){
		Item item = new Item();
		item.setTitle(title);
		item.setPrice(price);
		System.out.println(item);
		
		itemRepository.save(item);
		return "redirect:/list";
	}
}