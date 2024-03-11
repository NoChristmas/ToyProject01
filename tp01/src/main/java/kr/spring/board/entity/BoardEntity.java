package kr.spring.board.entity;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import kr.spring.member.entity.MemberEntity;

@Entity
@Table(name = "TP01BOARD")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bd_no;
    
    @Column
    private int ur_no;
    
    @Column
    private String ur_name;
    
    @Column
    private String bd_name;
    
    @Column
    private String bd_info;
    
    @Column
    private String bd_type;
    
    @Column
    private int bd_auth = 4;
    
    @Column
    private int bd_hit = 0;
    
    @Column
    private Date bd_reg_date;

    public BoardEntity() {
    }

    //Getters Setters
    public int getBd_no() {
        return bd_no;
    }

    public void setBd_no(int bd_no) {
        this.bd_no = bd_no;
    }

    public int getUr_no() {
        return ur_no;
    }

    public void setUr_no(int ur_no) {
        this.ur_no = ur_no;
    }

    public String getUr_name() {
        return ur_name;
    }

    public void setUr_name(String ur_name) {
        this.ur_name = ur_name;
    }

    public String getBd_name() {
        return bd_name;
    }

    public void setBd_name(String bd_name) {
        this.bd_name = bd_name;
    }

    public String getBd_info() {
        return bd_info;
    }

    public void setBd_info(String bd_info) {
        this.bd_info = bd_info;
    }

    public String getBd_type() {
        return bd_type;
    }

    public void setBd_type(String bd_type) {
        this.bd_type = bd_type;
    }

    public int getBd_auth() {
        return bd_auth;
    }

    public void setBd_auth(int bd_auth) {
        this.bd_auth = bd_auth;
    }

    public int getBd_hit() {
        return bd_hit;
    }

    public void setBd_hit(int bd_hit) {
        this.bd_hit = bd_hit;
    }

    public Date getBd_reg_date() {
        return bd_reg_date;
    }

    public void setBd_reg_date(Date bd_reg_date) {
        this.bd_reg_date = bd_reg_date;
    }
    
    public List<Object> toList() {
    	return Arrays.asList(bd_no, ur_no, ur_name, bd_name, bd_info, bd_type, bd_auth, bd_hit, bd_reg_date);
    }
}