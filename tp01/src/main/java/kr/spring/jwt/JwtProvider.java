package kr.spring.jwt;

import java.util.Base64;
import java.util.Date;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import kr.spring.member.dto.MemberDTO;
import kr.spring.member.dto.MemberDetails;

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
				.setExpiration(new Date(now.getTime()+(1000L * 60 * 60 * 2))) //2시간...
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
    
    //Filter에서 처리할 예정
    public Authentication getAuthentication(String token) {
    	Claims claims = getInformation(token);
    	
    	int ur_no = (int) claims.get("ur_no");
    	String ur_id = (String) claims.get("ur_id");
    	String ur_name = (String) claims.get("ur_name");
    	
    	MemberDTO memberDTO = new MemberDTO(ur_no, ur_id, null, ur_name, null, null, null);
        MemberDetails userDetails = new MemberDetails(memberDTO);
    	return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
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
