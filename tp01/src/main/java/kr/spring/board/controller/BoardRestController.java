package kr.spring.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.spring.board.dto.BoardDTO;
import kr.spring.board.service.BoardService;

@RestController
public class BoardRestController {
	
	@Autowired
	private BoardService boardService;
	
	//게시판 개수 가져오기
	@GetMapping("/api/board/countBoard")
	public int getCountBoard() {
		int cnt = boardService.getBoardCount();
		return cnt;
	}
	
	//To-Do 게시판 작성
	@PostMapping("/api/board/write")
	public Map<String,Object> writeBoard(@RequestParam BoardDTO boardDTO) {
		Map<String,Object> mapJson = new HashMap<>();
		//To-Do 게시판 작성하기
		return mapJson;
	}
	
	//데이터 가져오기
	@GetMapping("/api/board")
	public Map<String,Object> getBoards() {
		Map<String,Object> mapJson = new HashMap<>();
		//JWT 토큰 없으면 뱉기
		//CSRF 방어도 하나 필요 해 보임
		List<BoardDTO> list = boardService.getAllBoards();
		
		mapJson.put("result", "success");
		mapJson.put("count",boardService.getBoardCount());
		mapJson.put("list", list);
		
		return mapJson;
	}
	
	@GetMapping("/api/board/{bd_no}")
	public Map<String,Object> getBoard(@PathVariable("bd_no") int bd_no) {
		Map<String,Object> mapJson = new HashMap<>();
		List<BoardDTO> list = boardService.getBoard(bd_no);
		mapJson.put("result", "success");
		mapJson.put("count", list.size());
		mapJson.put("list", list);
		return mapJson;
	}
}
