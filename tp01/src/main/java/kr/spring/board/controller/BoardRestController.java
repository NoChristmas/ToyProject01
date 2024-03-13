package kr.spring.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import kr.spring.board.dto.BoardDTO;
import kr.spring.board.service.BoardServiceBackup;
import kr.spring.log.service.BoardLogService;
import kr.spring.board.service.BoardService;
import kr.spring.member.dto.MemberDTO;
import kr.spring.member.dto.MemberDetails;
import kr.spring.member.service.CookieService;

@RestController
public class BoardRestController {
	// 토큰값에서 가져온거 쓰기
	private int ur_no;
	private String ur_id;
	private String ur_name;

	private void init(HttpServletResponse response) throws IOException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.getPrincipal() instanceof MemberDetails) {
			MemberDetails userDetails = (MemberDetails) authentication.getPrincipal();
			this.ur_no = userDetails.getUr_no();
			this.ur_id = userDetails.getUsername();
			this.ur_name = userDetails.getUr_name();
		} else {
			response.sendRedirect("/member/login");
		}
	}

	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardLogService boardLogService;
	
	// 게시판 개수 가져오기
	@GetMapping("/api/board/countBoard")
	public int getCountBoard() {
		int cnt = boardService.getBoardCount();
		return cnt;
	}

	// 데이터 하나 가져오기
	@GetMapping("/api/board/{bd_no}")
	public Map<String, Object> getBoard(@PathVariable("bd_no") int bd_no,
			HttpServletResponse response) throws IOException {
		init(response);
		Map<String, Object> mapJson = new HashMap<>();
		List<BoardDTO> list = boardService.getBoard(bd_no);
		if(!list.isEmpty()) {
			int curHit = boardService.getCurrentBoardHit(bd_no);
			BoardDTO boardDTO = new BoardDTO();
			int increasedHit = curHit + 1;
			boardDTO.setBd_hit(increasedHit);
			boardDTO.setBd_no(bd_no);
			boardService.upHit(boardDTO);
			if(boardLogService.createBoardClickLog(boardDTO, ur_id)) {
				mapJson.put("log", "success");
			}
		} else { //게시글 없을 때
			mapJson.put("result", "fail");
			mapJson.put("message", "잘못된 접근입니다.");
			mapJson.put("redirectUrl", "/board/main");
			return mapJson;
		}
		mapJson.put("result", "success");
		mapJson.put("count", list.size());
		mapJson.put("list", list);
		return mapJson;
	}

	// 게시판 작성
	@PostMapping("/api/board")
	public Map<String, Object> writeBoard(@RequestBody BoardDTO boardDTO, HttpServletResponse response)
			throws IOException {
		Map<String, Object> mapJson = new HashMap<>();
		init(response);
		boardDTO.setUr_no(ur_no);
		boardDTO.setUr_name(ur_name);
		if (boardService.upsertBoard(boardDTO)) {
			mapJson.put("result", "success");
			mapJson.put("message", "글이 등록 되었습니다.");
			mapJson.put("redirectUrl", "/board/main");
			if(boardLogService.createBoardWriteLog(boardDTO, ur_id)) {
				mapJson.put("log", "success");
			}
		} else {
			mapJson.put("result", "fail");
			mapJson.put("message", "다시 시도하세요.");
		}

		return mapJson;
	}

	// 게시판 수정
	@PutMapping("/api/board/{bd_no}")
	public Map<String, Object> modifyBoard(@PathVariable("bd_no") int bd_no, @RequestBody BoardDTO boardDTO,
			HttpServletResponse response) throws IOException {
		Map<String, Object> mapJson = new HashMap<>();
		init(response);
		boardDTO.setBd_no(bd_no);
		boardDTO.setUr_no(ur_no);
		boardDTO.setUr_name(ur_name);
		if (boardService.upsertBoard(boardDTO)) {
			mapJson.put("result", "success");
			mapJson.put("message", "글이 수정 되었습니다.");
			mapJson.put("redirectUrl", "/board/detail?bd_no=" + bd_no);
			if(boardLogService.createBoardModifyLog(boardDTO, ur_id)) {
				mapJson.put("log", "success");
			}
		} else {
			mapJson.put("result", "fail");
			mapJson.put("message", "다시 시도하세요.");
		}
		return mapJson;
	}

	@DeleteMapping("/api/board/{bd_no}")
	public Map<String, Object> deleteBoard(@PathVariable("bd_no") int bd_no, HttpServletResponse response)
			throws IOException {
		init(response);
		Map<String, Object> mapJson = new HashMap<>();
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBd_no(bd_no);
		boardDTO.setUr_no(ur_no);

		if (boardService.deleteBoard(boardDTO)) {
			mapJson.put("result", "success");
			mapJson.put("message", "글이 삭제되었습니다.");
			mapJson.put("redirectUrl", "/board/main");
			if(boardLogService.createBoardDeleteLog(boardDTO, ur_id)) {
				mapJson.put("log", "success"); 
			}
		} else {
			mapJson.put("result", "fail");
			mapJson.put("message", "다시 시도하세요.");
		}
		return mapJson;
	}

	// 데이터 가져오기
	@GetMapping("/api/board")
	public Map<String, Object> getBoards() {
		Map<String, Object> mapJson = new HashMap<>();
		// JWT 토큰 없으면 뱉기
		List<BoardDTO> list = boardService.getAllBoards();

		mapJson.put("result", "success");
		mapJson.put("count", boardService.getBoardCount());
		mapJson.put("list", list);

		return mapJson;
	}

}
