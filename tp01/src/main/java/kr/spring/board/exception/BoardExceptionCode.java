package kr.spring.board.exception;

public enum BoardExceptionCode {
	
	POST_NOT_FOUND(404,"gg","POST_001")
	;
	
	private final int status;
	private final String code;
	private final String msg;
	
	BoardExceptionCode(int status ,String code, String msg) {
		this.status = status;
		this.code = code;
		this.msg = msg;
	}
	
	public int getStatus() {
		return status;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getMessage() {
		return msg;
	}
	
}