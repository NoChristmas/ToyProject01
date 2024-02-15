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
	
	//pw 가져오기
	@Select("SELECT ur_passwd FROM TP01MEMBER WHERE ur_id = #{ur_id}")
	public String getMemberPassword(String ur_id);
	
	//id
	@Select("SELECT COUNT(*) ur_id FROM TP01MEMBER WHERE ur_id = #{ur_id}")
	public int countMemberIdDupl(String ur_id);
	
	//id and pw 확인
	@Select("SELECT COUNT(*) ur_id FROM TP01MEMBER WHERE ur_id = #{ur_id} AND ur_pass = #{ur_passwd}")
	public int countMemberLogin(String ur_id, String ur_passwd);
	
	
}
