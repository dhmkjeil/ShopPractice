package com.roch.shop.notice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class NoticeController {
	
	private final NoticeRepository noticeRepository;
	private final NoticeService noticeService;
	
	@GetMapping("/notice")
	String noticeList(Model model) {
		noticeService.findAllNotice(model);
		return "noticeList.html";
	}
}
