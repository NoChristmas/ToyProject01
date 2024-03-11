package kr.spring.board.dto;

import java.sql.Date;

public class BoardDTO {
    private int bd_no;
    private int ur_no;
    private String ur_name;    
    private String bd_name;
    private String bd_info;
    private String bd_type;
    private int bd_auth;
    private int bd_hit;
    private Date bd_reg_date;

    public BoardDTO() {
    	this.bd_no = 0;
    	this.ur_no = 0;
    	this.ur_name = "unknown";
    	this.bd_name = null;
    	this.bd_info = null;
        this.bd_type = null;
        this.bd_auth = 4;
        this.bd_hit = 0;
        this.bd_reg_date = new java.sql.Date(System.currentTimeMillis());
    }

    public BoardDTO(int bd_no, int ur_no, String ur_name,String bd_name,String bd_info, String bd_type, int bd_auth, int bd_hit, Date bd_reg_date) {
        this.bd_no = bd_no;
        this.ur_no = ur_no;
        this.ur_name = ur_name;
        this.bd_name = bd_name;
        this.bd_info = bd_info;
        this.bd_type = bd_type;
        this.bd_auth = bd_auth;
        this.bd_hit = bd_hit;
        this.bd_reg_date = bd_reg_date;
    }

    // Getters
    public int getBd_no() {
        return bd_no;
    }

    public int getUr_no() {
        return ur_no;
    }
    
    public String getUr_name() {
    	return ur_name;
    }
    public String getBd_name() {
        return bd_name;
    }
    
    public String getBd_info() {
    	return bd_info;
    }
    
    public String getBd_type() {
        return bd_type;
    }

    public int getBd_auth() {
        return bd_auth;
    }

    public int getBd_hit() {
        return bd_hit;
    }

    public Date getBd_reg_date() {
        return bd_reg_date;
    }

    // Setters
    public void setBd_no(int bd_no) {
        this.bd_no = bd_no;
    }

    public void setUr_no(int ur_no) {
        this.ur_no = ur_no;
    }
    
    public void setUr_name(String ur_name) {
    	this.ur_name = ur_name;
    }
    
    public void setBd_name(String bd_name) {
        this.bd_name = bd_name;
    }
    
    public void setBd_info(String bd_info) {
    	this.bd_info = bd_info;
    }
    
    public void setBd_type(String bd_type) {
        this.bd_type = bd_type;
    }

    public void setBd_auth(int bd_auth) {
        this.bd_auth = bd_auth;
    }

    public void setBd_hit(int bd_hit) {
        this.bd_hit = bd_hit;
    }

    public void setBd_reg_date(Date bd_reg_date) {
        this.bd_reg_date = bd_reg_date;
    }

    // toString 메서드 (디버깅 및 로깅을 위해 사용)
    @Override
    public String toString() {
        return "BoardDTO{" +
                "bd_no=" + bd_no +
                ", ur_id='" + ur_no + '\'' +
                ", ur_name='" + ur_name + '\'' +
                ", bd_name='" + bd_name + '\'' +
                ", bd_type='" + bd_type + '\'' +
                ", bd_auth=" + bd_auth +
                ", bd_hit=" + bd_hit +
                ", bd_reg_date=" + bd_reg_date +
                '}';
    }
    
    //array 형태로 받아서 값을 설정하자
    public static BoardDTO fromArray(Object[] values) {
        if (values.length >= 9) {
        	return new BoardDTO(
        		(int) values[0],
                (int) values[1],
                (String) values[2],
                (String) values[3],
                (String) values[4],
                (String) values[5],
                (int) values[6],
                (int) values[7],
                (Date) values[8]
        	);
        }
        return null;
    }
    
    // 객체의 값을 배열로 반환하는 메서드
    public Object[] toArray() {
        return new Object[]{bd_no, ur_no, ur_name, bd_name, bd_info, bd_type, bd_auth, bd_hit, bd_reg_date};
    }
}
