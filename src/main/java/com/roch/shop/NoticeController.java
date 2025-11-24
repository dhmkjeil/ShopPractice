package com.roch.shop;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class NoticeController {
	
	private final NoticeRepository noticeRepository;
	
	@GetMapping("/notice")
	String noticeList(Model model) {
		List<Notice> notices = noticeRepository.findAll();
		model.addAttribute("notices", notices);
		System.out.println(notices.toString());
		return "noticeList.html";
	}
}
