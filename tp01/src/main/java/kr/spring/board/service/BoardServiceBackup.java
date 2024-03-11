package kr.spring.board.service;

import java.util.List;

import kr.spring.board.dto.BoardDTO;

public interface BoardServiceBackup {
	//게시판 개수 가져오기
	public int getBoardCount();
	
	//전부 가져오기
	public List<BoardDTO> getAllBoards();
	
	//하나 가져오기
	public List<BoardDTO> getBoard(int bd_no);
	
	//게시판 upsert
	public boolean upsertBoard(BoardDTO boardDTO);
	
	//게시판 삭제
	public boolean deleteBoard(BoardDTO boardDTO);
	
	//게시판 조회수 가져오기
	public int getCurrentBoardHit(int bd_no);
	
	//게시판 조회수 올리기
	public boolean upHit(BoardDTO boardDTO);
}
