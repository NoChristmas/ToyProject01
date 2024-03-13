package kr.spring.log.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.spring.board.dto.BoardDTO;
import kr.spring.log.entity.LogEntity;
import kr.spring.log.repository.LogRepository;

@Service
public class BoardLogService {
	@Autowired
	LogRepository logRepository;
	
	//게시판 클릭
	public boolean createBoardClickLog (BoardDTO boardDTO, String ur_id) {
		LogEntity memberLogEntity = new LogEntity();
		Date currentTime = new Date();
		
		memberLogEntity.setUrId(ur_id);
		memberLogEntity.setType("Board");
		memberLogEntity.setRegTime(currentTime);
		memberLogEntity.setContent(ur_id+" 님이 게시판 번호"+boardDTO.getBd_no()+"를 조회하셨습니다.");
		
		logRepository.save(memberLogEntity);
		return true;
	}
	
	//게시판 작성
	public boolean createBoardWriteLog (BoardDTO boardDTO, String ur_id) {
		LogEntity memberLogEntity = new LogEntity();
		Date currentTime = new Date();
		
		memberLogEntity.setUrId(ur_id);
		memberLogEntity.setType("Board");
		memberLogEntity.setRegTime(currentTime);
		memberLogEntity.setContent(ur_id+" 님이 게시판 번호"+boardDTO.getBd_no()+"를 작성하셨습니다.");
		
		logRepository.save(memberLogEntity);
		return true;
	}
	
	//게시판 수정
	public boolean createBoardModifyLog (BoardDTO boardDTO, String ur_id) {
		LogEntity memberLogEntity = new LogEntity();
		Date currentTime = new Date();
		
		memberLogEntity.setUrId(ur_id);
		memberLogEntity.setType("Board");
		memberLogEntity.setRegTime(currentTime);
		memberLogEntity.setContent(ur_id+" 님이 게시판 번호"+boardDTO.getBd_no()+"를 수정하셨습니다.");
		
		logRepository.save(memberLogEntity);
		return true;
	}
	
	//게시판 삭제
	public boolean createBoardDeleteLog (BoardDTO boardDTO, String ur_id) {
		LogEntity memberLogEntity = new LogEntity();
		Date currentTime = new Date();
		
		memberLogEntity.setUrId(ur_id);
		memberLogEntity.setType("Board");
		memberLogEntity.setRegTime(currentTime);
		memberLogEntity.setContent(ur_id+" 님이 게시판 번호"+boardDTO.getBd_no()+"를 삭제하셨습니다.");
		
		logRepository.save(memberLogEntity);
		return true;
	}
}
