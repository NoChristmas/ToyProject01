package kr.spring.member.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TP01MEMBER")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ur_no;
    
    @Column
    private String ur_id;

    @Column
    private String ur_passwd;

    @Column
    private String ur_name;

    @Column
    private String ur_email;

    @Column
    private Date ur_birth_date;

    @Column
    private Date ur_reg_date;

    public MemberEntity() {
    }

    // Getter와 Setter는 필요에 따라 추가
    public int getUr_no() {
        return ur_no;
    }

    public void setUr_no(int ur_no) {
        this.ur_no = ur_no;
    }

    public String getUr_id() {
        return ur_id;
    }

    public void setUr_id(String ur_id) {
        this.ur_id = ur_id;
    }

    public String getUr_passwd() {
        return ur_passwd;
    }

    public void setUr_passwd(String ur_passwd) {
        this.ur_passwd = ur_passwd;
    }

    public String getUr_name() {
        return ur_name;
    }

    public void setUr_name(String ur_name) {
        this.ur_name = ur_name;
    }

    public String getUr_email() {
        return ur_email;
    }

    public void setUr_email(String ur_email) {
        this.ur_email = ur_email;
    }

    public Date getUr_birth_date() {
        return ur_birth_date;
    }

    public void setUr_birth_date(Date ur_birth_date) {
        this.ur_birth_date = ur_birth_date;
    }

    public Date getUr_reg_date() {
        return ur_reg_date;
    }

    public void setUr_reg_date(Date ur_reg_date) {
        this.ur_reg_date = ur_reg_date;
    }
}
