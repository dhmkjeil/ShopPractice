package com.roch.shop.member;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository;
	private final PasswordEncoder myPasswordEncoder;
	
	public void addMember(String username, String displayName, String password) {
		
		if (username.length() < 6) {
			throw new IllegalArgumentException("아이디가 너무 짧습니다.");
		}
		
		if (password.length() < 8) {
			throw new IllegalArgumentException("비밀번호가 너무 짧습니다.");
		}
		
		Member member = new Member();
		member.setUsername(username);
		member.setDisplayName(displayName);
		member.setPassword(myPasswordEncoder.encode(password));
		memberRepository.save(member);
	}
}
