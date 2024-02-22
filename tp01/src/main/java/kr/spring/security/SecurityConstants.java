package kr.spring.security;


// Security 및 JWT 관련 상수를 관리하는 클래스
/**
 * HTTP
 * 		headers : {
 * 			Authorization : Bearer ${jwt}
 * 		}
 */
public class SecurityConstants {
	
	public static final String TOKEN_HEADER = "Authorization";
	
	public static final String TOKEN_PREFIX = "Bearer ";
	
	public static final String TOKEN_TYPE = "JWT";
}
