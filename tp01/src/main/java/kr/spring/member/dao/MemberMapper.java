package kr.spring.member.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import kr.spring.member.dto.MemberDTO;

@Mapper
public interface MemberMapper {
	
	//회원가입 진행
	@Insert("INSERT INTO TP01MEMBER (ur_id,ur_passwd,ur_name,ur_email,ur_birth_date) VALUES (#{ur_id},#{ur_passwd},#{ur_name},#{ur_email},#{ur_birth_date})")
	public void insertMember(MemberDTO memberDTO);
	
	//회원정보 수정
	
	//id
	@Select("SELECT COUNT(*) ur_id FROM TP01MEMBER WHERE ur_id = #{ur_id}")
	public int countMemberIdDupl(String ur_id);
	
	
}
