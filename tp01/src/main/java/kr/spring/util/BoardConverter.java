package kr.spring.util;

import kr.spring.board.dto.BoardDTO;
import kr.spring.board.entity.BoardEntity;

public class BoardConverter {
	
	public static BoardEntity DTOToEntity(BoardDTO boardDTO) {
		if (boardDTO != null) {
			BoardEntity boardEntity = new BoardEntity();
			boardEntity.setBd_no(boardDTO.getBd_no());
			boardEntity.setUr_no(boardDTO.getUr_no());
			boardEntity.setUr_name(boardDTO.getUr_name());
			boardEntity.setBd_name(boardDTO.getBd_name());
			boardEntity.setBd_info(boardDTO.getBd_info());
			boardEntity.setBd_type(boardDTO.getBd_type());
			boardEntity.setBd_auth(boardDTO.getBd_auth());
			boardEntity.setBd_hit(boardDTO.getBd_hit());
			boardEntity.setBd_reg_date(boardDTO.getBd_reg_date());
			return boardEntity;
		}
		return null;
	}
	
	public static BoardDTO EntityToDTO(BoardEntity boardEntity) {
		if (boardEntity != null) {
	        BoardDTO boardDTO = new BoardDTO();
	        boardDTO.setBd_no(boardEntity.getBd_no());
	        boardDTO.setUr_no(boardEntity.getUr_no());
	        boardDTO.setUr_name(boardEntity.getUr_name());
	        boardDTO.setBd_name(boardEntity.getBd_name());
	        boardDTO.setBd_info(boardEntity.getBd_info());
	        boardDTO.setBd_type(boardEntity.getBd_type());
	        boardDTO.setBd_auth(boardEntity.getBd_auth());
	        boardDTO.setBd_hit(boardEntity.getBd_hit());
	        boardDTO.setBd_reg_date(boardEntity.getBd_reg_date());
	        return boardDTO;
	    }
	    return null;
	}
}
