package kr.spring.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.spring.member.entity.MemberEntity;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {

	public int countByUrId(String ur_id);
	
	public MemberEntity findByUrId(String ur_id);

}