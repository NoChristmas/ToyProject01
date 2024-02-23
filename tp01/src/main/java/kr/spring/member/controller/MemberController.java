package kr.spring.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.spring.member.service.CookieService;

@Controller
public class MemberController {
	
	private final CookieService cookieService;
	
	public MemberController(CookieService cookieService) {
		this.cookieService = cookieService;
	}
	
	@GetMapping("/")
	public String getLoginPage(HttpServletRequest request) {
		String token = cookieService.getCookie(request, "token");
		if(!token.isEmpty()) {
			return "redirect:/board/main";
		}
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
		cookieService.deleteCookie(response,"token");
		return "redirect:/member/login";
	}
	
}
