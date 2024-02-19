package kr.spring.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import kr.spring.member.service.MemberService;
import kr.spring.member.dto.MemberDTO;

@Controller
public class MemberController {
	/*
	@Autowired
	MemberService memberService;
	*/
	@ModelAttribute
	public MemberDTO initCommand() {
		return  new MemberDTO();
	}
	
	
	@GetMapping("/")
	public String getLoginPage() {
		return "redirect:/member/login";
	}
	
	@GetMapping("/member/login")
	public String getMemberPage() {
		return "member/login";
	}
	
	
	@GetMapping("/member/register")
	public String memberRegister() {
		//회원가입은 누구나 환영
		return "member/register";
	}
	
	@GetMapping("/member/logout")
	public String memberLogout(HttpServletResponse response) {
		Cookie tokenCookie = new Cookie("token", "");
		tokenCookie.setMaxAge(0);
		tokenCookie.setPath("/");
		response.addCookie(tokenCookie);
		return "redirect:/";
	}
	
}
