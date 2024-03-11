package kr.spring.board.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kr.spring.board.dto.BoardDTO;
import kr.spring.board.entity.BoardEntity;
import kr.spring.board.repository.BoardRepository;
import kr.spring.util.BoardConverter;

@Service
@Transactional
public class BoardService {

	@Autowired
	BoardRepository boardRepository;

	// 게시판 전체 개수 가져오기
	public int getBoardCount() {
		int cnt = (int) boardRepository.count();
		return cnt;
	}

	// 게시판 데이터 가져오기
	public List<BoardDTO> getAllBoards() {
		List<BoardEntity> entityList = boardRepository.findAll();
		List<BoardDTO> list = new ArrayList<>();
		for(BoardEntity boardEntity : entityList) {
			list.add(BoardConverter.EntityToDTO(boardEntity));
		}
		return list;
	}

	// 게시판 하나 가져오기
	public List<BoardDTO> getBoard(int bd_no) {
		BoardEntity boardEntity = boardRepository.findById(bd_no).orElse(null);
		BoardDTO boardDTO = BoardConverter.EntityToDTO(boardEntity);
		if(boardEntity == null) {
			return Collections.emptyList();
		}
		return Collections.singletonList(boardDTO);
	}

	public boolean upsertBoard(BoardDTO boardDTO) {
		//List<BoardEntity> list = getBoard(boardDTO.getBd_no());
		BoardEntity boardEntity = BoardConverter.DTOToEntity(boardDTO);
		if (boardEntity != null) { //upsert 둘다 진행...
			boardRepository.save(boardEntity);
			return true;
		}
		return true;
	}

	public boolean deleteBoard(BoardDTO boardDTO) {
		int bd_no = boardDTO.getBd_no();
		int ur_no = boardDTO.getUr_no();
		BoardEntity boardEntity = boardRepository.findById(bd_no).get();
		if (boardEntity.getUr_no() == ur_no) { // 있는 게시글인지 확인
			boardRepository.deleteById(bd_no);
			return true;
		}
		return false;
	}

	// 게시판 조회수 가져오기
	public int getCurrentBoardHit(int bd_no) {
		BoardEntity boardEntity = boardRepository.findById(bd_no).orElse(null);
		if(boardEntity != null) {
			int hit = boardEntity.getBd_hit();
			return hit;
		}
		return 0;
	}

	// 게시판 조회수 올리기
	public boolean upHit(BoardDTO boardDTO) {
		BoardEntity boardEntity = boardRepository.findById(boardDTO.getBd_no()).orElse(null);
		boardEntity.setBd_hit(boardDTO.getBd_hit());
		boardRepository.save(boardEntity);
		return true;
	}
}
