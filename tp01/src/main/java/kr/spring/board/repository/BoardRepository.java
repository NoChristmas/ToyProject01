package kr.spring.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.spring.board.entity.BoardEntity;

@Repository
public interface BoardRepository extends JpaRepository <BoardEntity, Integer> {
	//특별한 것만 만들기
}
