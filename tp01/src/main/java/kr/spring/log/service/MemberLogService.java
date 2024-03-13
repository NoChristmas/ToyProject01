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
	
	public boolean createMemberLoginLog (MemberDTO memberDTO) {
		MemberLogEntity memberLogEntity = new MemberLogEntity();
		String ur_id = memberDTO.getUr_id();
		Date currentTime = new Date();
	
		memberLogEntity.setType("Member");
		memberLogEntity.setRegTime(currentTime);
		memberLogEntity.setContent(ur_id+" 님이 로그인 하였습니다.");
		
		memberLogRepository.save(memberLogEntity);
		return true;
	}
}
