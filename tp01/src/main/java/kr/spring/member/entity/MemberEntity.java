package kr.spring.member.entity;

import java.sql.Date;

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
    @Column(name = "ur_no")
    private int urNo;

    @Column(name = "ur_id")
    private String urId;

    @Column(name = "ur_passwd")
    private String urPasswd;

    @Column(name = "ur_name")
    private String urName;

    @Column(name = "ur_email")
    private String urEmail;

    @Column(name = "ur_birth_date")
    private Date urBirthDate;

    @Column(name = "ur_reg_date")
    private Date urRegDate;

    public MemberEntity() {
    }

    public int getUrNo() {
        return urNo;
    }

    public void setUrNo(int urNo) {
        this.urNo = urNo;
    }

    public String getUrId() {
        return urId;
    }

    public void setUrId(String urId) {
        this.urId = urId;
    }

    public String getUrPasswd() {
        return urPasswd;
    }

    public void setUrPasswd(String urPasswd) {
        this.urPasswd = urPasswd;
    }

    public String getUrName() {
        return urName;
    }

    public void setUrName(String urName) {
        this.urName = urName;
    }

    public String getUrEmail() {
        return urEmail;
    }

    public void setUrEmail(String urEmail) {
        this.urEmail = urEmail;
    }

    public Date getUrBirthDate() {
        return urBirthDate;
    }

    public void setUrBirthDate(Date urBirthDate) {
        this.urBirthDate = urBirthDate;
    }

    public Date getUrRegDate() {
        return urRegDate;
    }

    public void setUrRegDate(Date urRegDate) {
        this.urRegDate = urRegDate;
    }
}