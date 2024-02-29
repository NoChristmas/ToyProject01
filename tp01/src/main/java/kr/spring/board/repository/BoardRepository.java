package kr.spring.board.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kr.spring.board.dto.BoardDTO;

@Repository
@Mapper
@Qualifier("oracle")
public interface BoardRepository {
	@Select("SELECT bd_hit FROM TP01BOARD WHERE bd_no = #{bd_no}")
	public int selectBoardHit(int bd_no);
	
	@Update("UPDATE TP01BOARD SET bd_hit = #{bd_hit} WHERE bd_no = #{bd_no}")
	public void updateBoardHit(BoardDTO boardDTO);
	
	@Select("SELECT COUNT(*) bd_no FROM TP01BOARD")
	public int getBoardCount();
	
	@Select("SELECT B.bd_no, B.ur_no, B.bd_name, M.ur_name, B.bd_type, B.bd_hit, B.bd_reg_date "
			+ "FROM TP01BOARD B JOIN TP01MEMBER M ON M.ur_no = B.ur_no")
	public List<BoardDTO> getBoards();
	
	@Select("SELECT B.bd_no, B.bd_name, M.ur_no, M.ur_name, B.bd_type ,B.bd_info, B.bd_reg_date, B.bd_hit "
			+ "FROM TP01BOARD B JOIN TP01MEMBER M ON B.ur_no = M.ur_no WHERE bd_no = #{bd_no}")
	public List<BoardDTO> getBoard(int bd_no);
	
	@Insert("INSERT INTO TP01BOARD (ur_no, ur_name, bd_name, bd_info, bd_type) VALUES (#{ur_no}, #{ur_name},#{bd_name}, #{bd_info}, #{bd_type})")
	public void insertBoard(BoardDTO boardDTO);
	
	@Update("UPDATE TP01BOARD SET ur_name = #{ur_name}, bd_name = #{bd_name}, bd_info = #{bd_info}, bd_type = #{bd_type} WHERE bd_no = #{bd_no}")
	public void updateBoard(BoardDTO boardDTO);
	
	@Delete("DELETE FROM TP01BOARD WHERE bd_no = #{bd_no} AND ur_no = #{ur_no}")
	public void deleteBoard(BoardDTO boardDTO);
}
