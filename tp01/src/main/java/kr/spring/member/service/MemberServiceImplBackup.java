package kr.spring.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.spring.member.dao.MemberMapper;
import kr.spring.member.dto.MemberDTO;
import kr.spring.member.repository.MemberRepository;
import kr.spring.security.JwtProvider;

@Service
@Transactional
public class MemberServiceImplBackup implements MemberServiceBackup {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	//id 중복 여부
	@Override
	public boolean checkMemberIdDupl(String ur_id) {
		int howManyMembers = memberMapper.countMemberIdDupl(ur_id);
		return howManyMembers >=1;
	};
		
	//ID and Passwd Check
	@Override
	public boolean checkMemberId(String ur_id, String ur_passwd) {
		if(checkMemberIdDupl(ur_id)) {
			if(passwordEncoder.matches(ur_passwd,memberMapper.getMemberPassword(ur_id))) {
				return true;
			}
		}
		return false; 
	};
	
	//회원가입
	@Override
	public boolean upsertMember(MemberDTO memberDTO) {
		//id 중복 여부
		String ur_id = memberDTO.getUr_id();
		if(checkMemberIdDupl(ur_id)) {
			return false;
		}
		//passwd 인코딩
		String ur_passwd = memberDTO.getUr_passwd();
		String encodingPassword = passwordEncoder.encode(ur_passwd);
		memberDTO.setUr_passwd(encodingPassword);
		memberMapper.insertMember(memberDTO);
		return true;
	};
	
	
	@Override
	public MemberDTO getMember(String ur_id) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO = memberMapper.getMemberInfo(ur_id);
		if(memberDTO == null) {
			return null;
		}
		return memberDTO;
	}
	
	@Override
	public String createToken(String ur_id) {
		MemberDTO memberDTO = null; 
		memberDTO = getMember(ur_id);
		int ur_no = memberDTO.getUr_no();
		String ur_name = memberDTO.getUr_name();
		return jwtProvider.createToken(ur_no, ur_id, ur_name);
	}
	
}
