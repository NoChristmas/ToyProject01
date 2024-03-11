package kr.spring.jwt;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.spring.member.service.CookieService;

public class JwtFilter extends GenericFilterBean {
	private static final String AUTHORIZATION_HEADER = "Authorization";
	
	private final JwtProvider jwtProvider;
	private final CookieService cookieService;
	
	public JwtFilter(JwtProvider jwtProvider, CookieService cookieService) {
		this.jwtProvider = jwtProvider;
		this.cookieService = cookieService;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String token = cookieService.getCookie(httpRequest, "token");
		//String token = resolveToken(httpRequest);
		if(StringUtils.hasText(token) && jwtProvider.validateToken(token)) {
			Authentication authenticate = jwtProvider.getAuthentication(token);
			SecurityContextHolder.getContext().setAuthentication(authenticate);
		} else {
            System.out.println("Token이 없음");
        }
        chain.doFilter(request, response);
	}
	
	private String resolveToken(HttpServletRequest request) {
		String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}
		return null;
	}
}