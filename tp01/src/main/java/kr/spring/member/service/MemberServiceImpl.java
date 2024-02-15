package kr.spring.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.spring.member.dao.MemberMapper;
import kr.spring.member.dto.MemberDTO;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
		
	//id 중복 여부
	@Override
	public boolean checkMemberIdDupl(String ur_id) {
		int howManyMembers = memberMapper.countMemberIdDupl(ur_id);
		return howManyMembers >=1;
	};
		
	//로그인 여부
	@Override
	public boolean checkMemberId(String ur_id, String ur_passwd) {
		if(checkMemberIdDupl(ur_id)) {
			if(passwordEncoder.matches(ur_passwd,memberMapper.getMemberPassword(ur_id))) {
				System.out.println("패스워드 매칭 됨");
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
	
}
