package kr.spring.board.service;

import java.util.List;

import kr.spring.board.dto.BoardDTO;

public interface BoardService {
	//게시판 개수 가져오기
	public int getBoardCount();
	
	//전부 가져오기
	public List<BoardDTO> getAllBoards();
	
	//하나 가져오기
	public List<BoardDTO> getBoard(int bd_no);
	
}
