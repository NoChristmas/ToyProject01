package kr.spring.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MemberController {
	
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
		return "member/register";
	}
	
	@GetMapping("/member/logout")
	public String memberLogout(HttpServletResponse response) {
		Cookie tokenCookie = new Cookie("token", "");
		tokenCookie.setMaxAge(0);
		tokenCookie.setPath("/");
		response.addCookie(tokenCookie);
		return "redirect:/member/login";
	}
	
}
