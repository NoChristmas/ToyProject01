package kr.spring.security;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CookieService {
	public void addCookie(HttpServletResponse response, String key, String value) {
        Cookie cookie = new Cookie(key, value);

        //30분
        int maxAgeInSeconds = 60 * 60 * 2;
        cookie.setMaxAge(maxAgeInSeconds);

        // 쿠키의 유효 경로 설정 (선택 사항)
        // 예: "/"로 설정하면 모든 경로에서 접근 가능
        cookie.setPath("/");

        // 쿠키를 HTTPS에서만 전송하도록 설정 (선택 사항)
        // cookie.setSecure(true);

        // HTTP-Only 속성을 사용하여 JavaScript에서 쿠키에 접근하지 못하게 설정 (선택 사항)
        // cookie.setHttpOnly(true);

        // 쿠키를 응답 헤더에 추가
        response.addCookie(cookie);
    }
	
	public String getCookie(HttpServletRequest request, String key) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(key.equals(cookie.getName())) {
					System.out.println("cookie값 들어옴");
					return cookie.getValue();
				}
			}
		}
		return "";
	}
}
