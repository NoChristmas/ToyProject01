package kr.spring.board.dto;

import java.sql.Date;

public class BoardDTO {
    private int bd_no;
    private String ur_id;
    private String bd_name;
    private String bd_type;
    private int bd_auth;
    private int bd_hit;
    private Date bd_reg_date;

    public BoardDTO() {}

    public BoardDTO(int bd_no, String ur_id, String bd_name, String bd_type, int bd_auth, int bd_hit, Date bd_reg_date) {
        this.bd_no = bd_no;
        this.ur_id = ur_id;
        this.bd_name = bd_name;
        this.bd_type = bd_type;
        this.bd_auth = bd_auth;
        this.bd_hit = bd_hit;
        this.bd_reg_date = bd_reg_date;
    }

    // Getters
    public int getBd_no() {
        return bd_no;
    }

    public String getUr_id() {
        return ur_id;
    }

    public String getBd_name() {
        return bd_name;
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

    public void setUr_id(String ur_id) {
        this.ur_id = ur_id;
    }

    public void setBd_name(String bd_name) {
        this.bd_name = bd_name;
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
                ", ur_id='" + ur_id + '\'' +
                ", bd_name='" + bd_name + '\'' +
                ", bd_type='" + bd_type + '\'' +
                ", bd_auth=" + bd_auth +
                ", bd_hit=" + bd_hit +
                ", bd_reg_date=" + bd_reg_date +
                '}';
    }
}
