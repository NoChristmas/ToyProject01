package kr.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.spring.board.dao.BoardMapper;
import kr.spring.board.dto.BoardDTO;
import kr.spring.board.repository.BoardRepository;

@Service
@Transactional
public class BoardServiceImplBackup implements BoardServiceBackup {
	
	@Autowired
	private BoardMapper boardMapper;
	
	//게시판 전체 개수 가져오기
	@Override
	public int getBoardCount() {
		int cnt = boardMapper.getBoardCount();
		return cnt;
	}
			
	//게시판 데이터 가져오기
	@Override
	public List<BoardDTO> getAllBoards() {
		List<BoardDTO> list = boardMapper.getBoards();
		return list;
	}
	
	//게시판 하나 가져오기
	@Override
	public List<BoardDTO> getBoard(int bd_no) {
		List<BoardDTO> list = boardMapper.getBoard(bd_no);
		return list;
	}
	
	@Override
	public boolean upsertBoard(BoardDTO boardDTO) {
		List<BoardDTO> list = getBoard(boardDTO.getBd_no());
		if(!list.isEmpty()) { //있는 게시글인지 확인
			boardMapper.updateBoard(boardDTO);
			return true;
		}
		boardMapper.insertBoard(boardDTO);
		return true;
	}
	
	@Override
	public boolean deleteBoard(BoardDTO boardDTO) {
		List<BoardDTO> list = getBoard(boardDTO.getBd_no());
		if(!list.isEmpty()) { //있는 게시글인지 확인
			boardMapper.deleteBoard(boardDTO);
			return true;
		}
		return false;
	}
	
	//게시판 조회수 가져오기
	@Override
	public int getCurrentBoardHit(int bd_no) {
		int hit = boardMapper.selectBoardHit(bd_no);
		return hit;
	}
		
	//게시판 조회수 올리기
	@Override
	public boolean upHit(BoardDTO boardDTO) {
		boardMapper.updateBoardHit(boardDTO);
		return true;
	}
}
