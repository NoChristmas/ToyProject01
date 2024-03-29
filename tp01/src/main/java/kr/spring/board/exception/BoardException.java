package kr.spring.board.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class BoardException extends RuntimeException {
	
	private final BoardExceptionCode boardExceptionCode;
	
	public BoardException(BoardExceptionCode boardExceptionCode) {
		this.boardExceptionCode = boardExceptionCode;
	}
	
	public BoardExceptionCode getBoardExceptionCode() {
		return boardExceptionCode;
	}
}
