package kr.spring.board.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.spring.board.service.BoardServiceBackup;


@Controller
public class BoardController {
	
	@GetMapping("/board/main")
	public String getBoardMainPage() {
		return "board/main";
	}
	
	@GetMapping("/board/detail")
	public String getBoardDetail() {
		return "board/detail";
	}
	
	@GetMapping("/board/write")
	public String getBoardWritePage() {
		return "board/write";
	}
	
	@GetMapping("/board/modify")
	public String getModifyPage() {
		return "board/modify";
	}
	
	@GetMapping("/board/test")
	public String getBoardTestPage() {
		return "board/test";
	}
}
