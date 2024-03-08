package kr.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.DispatcherType;
import kr.spring.member.service.CookieService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	JwtProvider jwtProvider;
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    SecurityFilterChain filterChain(HttpSecurity http
    		,JwtProvider jwtProvider, CookieService cookieService) throws Exception {
		
		http
			.formLogin().disable()
			.csrf().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            
            .and()
            .authorizeHttpRequests()
            .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
            .requestMatchers("/api/member/**").permitAll()
            .requestMatchers("/lib/**").permitAll()
			.requestMatchers("/member/**").permitAll()
			.requestMatchers("/").permitAll()
			.requestMatchers("/thymeleaf/main.do").permitAll() //thymeleaf 임시 해제
            .anyRequest().authenticated() // white list 기반
			
            .and()
            .addFilterBefore(new JwtFilter(jwtProvider, cookieService), UsernamePasswordAuthenticationFilter.class);
		
		
        return http.build();
    }
    
}
