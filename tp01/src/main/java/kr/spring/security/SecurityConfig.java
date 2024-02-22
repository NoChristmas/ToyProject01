package kr.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.DispatcherType;

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
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
			.formLogin().disable()
			.csrf().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            
            .and()
            .authorizeHttpRequests()
            .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
			.requestMatchers("/lib/**").permitAll()
            .requestMatchers("/api/member/**").permitAll()
			.requestMatchers("/member/**").permitAll()
			.requestMatchers("/").permitAll()
            .anyRequest().authenticated() // white list 기반
			
            .and()
            .addFilterBefore(new JwtFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class);
		
		
        return http.build();
    }
    
}
