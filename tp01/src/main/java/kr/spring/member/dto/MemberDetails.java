package kr.spring.member.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

//UsernamePasswordAuthenticationToken에 파싱하기 위한 class
public class MemberDetails implements UserDetails {

    private final MemberDTO memberDTO;

    public MemberDetails(final MemberDTO memberDTO) {
        this.memberDTO = memberDTO;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // You might adjust this based on your application's logic for handling roles/authorities
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
        return authorities;
    }

    @Override
    public String getPassword() {
        return memberDTO.getUr_passwd();
    }

    @Override
    public String getUsername() {
        return memberDTO.getUr_id();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // You might add logic to check if the account is expired
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // You might add logic to check if the account is locked
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // You might add logic to check if credentials (password) are expired
    }

    @Override
    public boolean isEnabled() {
        return true; // You might add logic to check if the user is enabled
    }

    // Additional methods to expose MemberDTO details
    public int getUr_no() {
        return memberDTO.getUr_no();
    }

    public String getUr_name() {
        return memberDTO.getUr_name();
    }

    // Other getters as needed

    // You might also want to override equals() and hashCode() based on your requirements

}
