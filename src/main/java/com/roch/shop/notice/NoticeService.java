package com.roch.shop.notice;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeService {

	private final NoticeRepository noticeRepository;
	
	public void findAllNotice(Model model) {
		List<Notice> notices = noticeRepository.findAll();
		model.addAttribute("notices", notices);
		System.out.println(notices.toString());
	}
}
