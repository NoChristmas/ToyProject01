package kr.spring.board.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class BoardException extends RuntimeException {
	
	//ExceptionCode 넣기
	private final BoardExceptionCode boardExceptionCode;
	
	//ExceptionCode를 생성자로부터 받아서 세팅
	public BoardException(BoardExceptionCode boardExceptionCode) {
		this.boardExceptionCode = boardExceptionCode;
	}
	
	//getters this is for commit & push
	public BoardExceptionCode getBoardExceptionCode() {
		return boardExceptionCode;
	}
}
