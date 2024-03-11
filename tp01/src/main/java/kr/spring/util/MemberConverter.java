package kr.spring.util;

import kr.spring.member.dto.MemberDTO;
import kr.spring.member.entity.MemberEntity;

public class MemberConverter {
    
	public static MemberEntity DTOToEntity(MemberDTO memberDTO) {
        if (memberDTO != null) {
            MemberEntity memberEntity = new MemberEntity();
            memberEntity.setUrNo(memberDTO.getUr_no());
            memberEntity.setUrId(memberDTO.getUr_id());
            memberEntity.setUrPasswd(memberDTO.getUr_passwd());
            memberEntity.setUrName(memberDTO.getUr_name());
            memberEntity.setUrEmail(memberDTO.getUr_email());
            memberEntity.setUrBirthDate(memberDTO.getUr_birth_date());
            memberEntity.setUrRegDate(memberDTO.getUr_reg_date());
            return memberEntity;
        }
        return null;
    }

    public static MemberDTO EntityToDTO(MemberEntity memberEntity) {
        if (memberEntity != null) {
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setUr_no(memberEntity.getUrNo());
            memberDTO.setUr_id(memberEntity.getUrId());
            memberDTO.setUr_passwd(memberEntity.getUrPasswd());
            memberDTO.setUr_name(memberEntity.getUrName());
            memberDTO.setUr_email(memberEntity.getUrEmail());
            memberDTO.setUr_birth_date(memberEntity.getUrBirthDate());
            memberDTO.setUr_reg_date(memberEntity.getUrRegDate());
            return memberDTO;
        }
        return null;
    }
}
