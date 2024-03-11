package kr.spring.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kr.spring.jwt.JwtProvider;
import kr.spring.member.dto.MemberDTO;
import kr.spring.member.entity.MemberEntity;
import kr.spring.member.repository.MemberRepository;
import kr.spring.util.MemberConverter;

@Service
@Transactional
public class MemberService {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtProvider jwtProvider;

	// id 중복 여부
	public boolean checkMemberIdDupl(String ur_id) {
		int howManyMembers = memberRepository.countByUrId(ur_id);
		return howManyMembers >= 1;
	};

	// ID and Passwd Check
	public boolean checkMemberId(String ur_id, String ur_passwd) {
		if(checkMemberIdDupl(ur_id)) {
			MemberEntity memberEntity = memberRepository.findByUrId(ur_id);
			if (passwordEncoder.matches(ur_passwd, memberEntity.getUrPasswd())) {
				return true;
			}
		}
		return false;
	};

	// 회원가입
	public boolean upsertMember(MemberDTO memberDTO) {
		// id 중복 여부
		String ur_id = memberDTO.getUr_id();
		if (checkMemberIdDupl(ur_id)) {
			return false;
		}
		// passwd 인코딩
		String encodingPassword = passwordEncoder.encode(memberDTO.getUr_passwd());
		memberDTO.setUr_passwd(encodingPassword);
		MemberEntity memberEntity = MemberConverter.DTOToEntity(memberDTO);
		memberRepository.save(memberEntity);
		return true;
	};

	public MemberDTO getMember(String ur_id) {
		MemberEntity memberEntity = memberRepository.findByUrId(ur_id);
		//ur_no, ur_id, ur_name
		MemberDTO memberDTO = MemberConverter.EntityToDTO(memberEntity);
		if (memberDTO == null) {
			return null;
		}
		memberDTO.setUr_passwd(null);
		memberDTO.setUr_email(null);
		memberDTO.setUr_birth_date(null);
		return memberDTO;
	}

	public String createToken(String ur_id) {
		MemberDTO memberDTO = getMember(ur_id);
		int ur_no = memberDTO.getUr_no();
		String ur_name = memberDTO.getUr_name();
		return jwtProvider.createToken(ur_no, ur_id, ur_name);
	}
}
