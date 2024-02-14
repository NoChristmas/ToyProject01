package kr.spring.member.service;

import kr.spring.member.dto.MemberDTO;

public interface MemberService {
	
	//id 중복 여부
	public boolean checkMemberIdDupl(String ur_id);
	
	//로그인 여부
	public boolean checkMemberId(String ur_id, String ur_passwd);
	
	
	//회원가입 및 정보 수정
	public boolean upsertMember(MemberDTO memberDTO);
}
