package com.roch.shop.member;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	
	private final PasswordEncoder myPasswordEncoder;
	private final MemberService memberService;
	
	@GetMapping("/signup")
	public String signup () {
		return "signup.html";
	}
	
	@PostMapping("/addMember")
	public String addMember(
			@RequestParam("username") String username,
			@RequestParam("displayName") String displayName,
			@RequestParam("password") String password) {
		try {
			memberService.addMember(username, displayName, password);
			return "redirect:/list";
		} catch (Exception e) {
			e.getMessage();
			return "/signup";
		}
	}
}
