package kr.spring.security;

import java.util.Base64;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class JwtProvider {
	//secretKey는 원래 숨겨아됨
	private static String secretKey = Base64.getEncoder().encodeToString("jeonghopark".getBytes());
	
	// 토큰 만들기
	public String createToken(int ur_no, String ur_id, String ur_name) {
		Claims claims = Jwts.claims();
		claims.put("ur_no", ur_no);
		claims.put("ur_id", ur_id);
		claims.put("ur_name", ur_name);
		Date now = new Date();
		
		return Jwts.builder()
				.setHeaderParam(Header.TYPE, Header.JWT_TYPE)
				.setClaims(claims)
				.setIssuedAt(now)
				.setExpiration(new Date(now.getTime()+(1000L * 60 * 30)))
				.signWith(SignatureAlgorithm.HS256, secretKey)
				.compact();
	}
	
	// Jwt Token 유효성 검사
	public boolean validateToken(String jwtToken) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }
    
	// 토큰에서 정보 가져오기
	public String getSubject(String jwtToken) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken).getBody().getSubject();
	}
	
    // Jwt Token 데이터 확인
    public Claims getInformation(String token) {
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        return claims;
    }
    
    // cookie 값에서 가져올 때
    public String resolveToken(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
        	for(Cookie cookie : cookies) {
        		if(cookie.getName().equals("token")) {
        			return cookie.getValue();
        		}
        	}
        }
        return null;
    	//return request.getHeader("X-AUTH-TOKEN");
    }
}
