package kr.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.spring.board.dao.BoardMapper;
import kr.spring.board.dto.BoardDTO;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	//게시판 개수 가져오기
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
		
}
