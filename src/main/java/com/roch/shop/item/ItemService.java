package com.roch.shop.item;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {
	
	private final ItemRepository itemRepository;
	
	public void findAllItem(Model model) {
		List<Item> result = itemRepository.findAll();
		model.addAttribute("items", result);
	}
	
	public void saveItem(Long id, String title, String price) {
		if (title.isEmpty() || price.isEmpty()) {
			throw new NullPointerException("비어있는 값이 있으면 안됩니다.");
		}
		
		if (title.length() > 100) {
			throw new IllegalArgumentException("상품명이 너무 깁니다.");
		} 
		
		try {
			long tempPrice = Long.parseLong(price);
			
			if (tempPrice < 0) {
				throw new IllegalArgumentException("가격은 음수일수 없습니다.");
			} else if (tempPrice > Integer.MAX_VALUE) {
				throw new IllegalArgumentException("가격이 너무 큽니다.");
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("가격은 숫자여야 합니다.");
		}
		
		Item item = new Item();
		if (id == 0L) {
			item.setTitle(title);
			item.setPrice(Integer.parseInt(price));
		} else {
			Optional<Item> result = itemRepository.findById(id);
			if (result.isPresent()) {
				item = result.get();
				item.setTitle(title);
				item.setPrice(Integer.parseInt(price));
			}
		}
		itemRepository.save(item);
	}
	
	public void itemDetail(Model model, Long id) {
		Optional<Item> result = itemRepository.findById(id);
		if (!result.isPresent()) {
			throw new NoSuchElementException("해당 상품은 없습니다.");
		}
		model.addAttribute("detail", result.get());
	}
	
	public void itemFix(Model model, Long id) {
		Optional<Item> result = itemRepository.findById(id);
		if (!result.isPresent()) {
			throw new NoSuchElementException("해당 상품은 없습니다.");
		}
		model.addAttribute("item", result.get());
	}
}
