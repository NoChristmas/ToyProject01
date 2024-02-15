package kr.spring.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.spring.member.dto.MemberDTO;
import kr.spring.member.service.MemberService;

@RestController
public class MemberRestController {
	
	@Autowired 
	private MemberService memberService;
	
	@PostMapping("/api/member/login")
	public Map<String,Object> checkLogin(@RequestBody MemberDTO memberDTO) {
		Map<String, Object> mapJson = new HashMap<>();
		String ur_id = memberDTO.getUr_id();
		String ur_pass = memberDTO.getUr_passwd();
		
		boolean isMatched = memberService.checkMemberId(ur_id, ur_pass);
		if(!isMatched) {
			mapJson.put("result", "fail");
			mapJson.put("message", "ID or passwd가 틀렸습니다");
		} else {
			mapJson.put("result", "success");
			mapJson.put("redirectUrl","/board/main");
		}
		return mapJson;
	}
	
	@GetMapping("/api/member/duplication")
	public Map<String, Object> checkIdDuplication(@RequestParam String ur_id) {
		Map<String, Object> mapJson = new HashMap<>();
		boolean isDuplicated = memberService.checkMemberIdDupl(ur_id);
		if(isDuplicated) {
			mapJson.put("result", "fail");
			mapJson.put("message", "아이디 중복됨");
		} else {
			mapJson.put("result", "success");
		}
		return mapJson;
	}
	
	@PostMapping("/api/member/register")
	public Map<String,Object> registerMember(@RequestBody MemberDTO memberDTO) {
		Map<String,Object> mapJson = new HashMap<>();
		boolean isSuccess = memberService.upsertMember(memberDTO);
		if(isSuccess) {
			mapJson.put("result","success");
			mapJson.put("redirectUrl","/member/login");
		} else {
			mapJson.put("result", "fail");
			mapJson.put("message", "fail To Upload");
		}
		return mapJson;
	}
}
