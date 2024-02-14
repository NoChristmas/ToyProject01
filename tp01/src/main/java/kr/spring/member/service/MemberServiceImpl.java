package kr.spring.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.spring.member.dao.MemberMapper;
import kr.spring.member.dto.MemberDTO;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	//id 중복 여부
	@Override
	public boolean checkMemberIdDupl(String ur_id) {
		int howManyMembers = memberMapper.countMemberIdDupl(ur_id);
		return howManyMembers >=1;
	};
		
	//로그인 여부
	@Override
	public boolean checkMemberId(String ur_id, String ur_passwd) {
		
		return true;
	};
	
	//회원가입
	@Override
	public boolean upsertMember(MemberDTO memberDTO) {
		String ur_id = memberDTO.getUr_id();
		
		if(checkMemberIdDupl(ur_id)) {
			return false;
		}
		
		memberMapper.insertMember(memberDTO);
		return true;
	};
	
}
