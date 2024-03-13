package kr.spring.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.spring.jwt.JwtProvider;
import kr.spring.log.service.MemberLogService;
import kr.spring.member.service.CookieService;

@Controller
public class MemberController {
	
	@Autowired
	MemberLogService memberLogService;
	
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
	public String memberLogout(HttpServletRequest request, HttpServletResponse response) {
		String token = cookieService.getCookie(request,"token");
		cookieService.deleteCookie(response,"token");
		JwtProvider jwtProvider = new JwtProvider();
		String ur_id = jwtProvider.getUrId(token);
		//멤버 로그아웃 토큰으로 받기
		memberLogService.createMemberLogoutLog(ur_id);
		return "redirect:/member/login";
	}
	
	@GetMapping("/thymeleaf/main.do")
	public String getMainPage() {
		return "thymeleaf/main";
	}
}
