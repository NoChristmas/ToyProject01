package kr.spring.log.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.spring.log.entity.MemberLogEntity;
import kr.spring.log.repository.MemberLogRepository;
import kr.spring.member.dto.MemberDTO;

@Service
public class MemberLogService {
	
	@Autowired
	MemberLogRepository memberLogRepository;
	
	//로그아웃
	public boolean createMemberLogoutLog (String ur_id) {
		MemberLogEntity memberLogEntity = new MemberLogEntity();
		Date currentTime = new Date();
		
		memberLogEntity.setUrId(ur_id);
		memberLogEntity.setType("Member");
		memberLogEntity.setRegTime(currentTime);
		memberLogEntity.setContent(ur_id+" 님이 로그아웃 하셨습니다.");
		
		memberLogRepository.save(memberLogEntity);
		return true;
	}
	
	//로그인
	public boolean createMemberLoginLog (MemberDTO memberDTO) {
		MemberLogEntity memberLogEntity = new MemberLogEntity();
		String ur_id = memberDTO.getUr_id();
		Date currentTime = new Date();
		
		memberLogEntity.setUrId(ur_id);
		memberLogEntity.setType("Member");
		memberLogEntity.setRegTime(currentTime);
		memberLogEntity.setContent(ur_id+" 님이 로그인 하였습니다.");
		
		memberLogRepository.save(memberLogEntity);
		return true;
	}
	
	//회원가입
	public boolean createMemberRegisterLog (MemberDTO memberDTO) {
		MemberLogEntity memberLogEntity = new MemberLogEntity();
		Date currentTime = new Date();
		//memberLogEntity.setUrId(ur_id);
		memberLogEntity.setType("Register");
		memberLogEntity.setRegTime(currentTime);
		memberLogEntity.setContent(memberDTO.getUr_id()+" 님이 가입 되었습니다.");
		
		memberLogRepository.save(memberLogEntity);
		return true;
	}
}