package kr.spring.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import kr.spring.board.dto.BoardDTO;


@Mapper
public interface BoardMapper {
	
	@Select("SELECT COUNT(*) bd_no FROM TP01BOARD")
	public int getBoardCount();
	
	@Select("SELECT B.bd_no, B.ur_no, B.bd_name, M.ur_name, B.bd_type, B.bd_auth, B.bd_reg_date "
			+ "FROM TP01BOARD B JOIN TP01MEMBER M ON M.ur_no = B.ur_no")
	public List<BoardDTO> getBoards();
	
	@Select("SELECT B.bd_no, B.bd_name, M.ur_no, M.ur_name, B.bd_type ,B.bd_info, B.bd_reg_date, B.bd_hit "
			+ "FROM TP01BOARD B JOIN TP01MEMBER M ON B.ur_no = M.ur_no WHERE bd_no = #{bd_no}")
	public List<BoardDTO> getBoard(int bd_no);
}
