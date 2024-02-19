package kr.spring.member.dto;

import java.sql.Date;

public class MemberDTO {
	private int ur_no;
	private String ur_id;
	private String ur_passwd;
	private String ur_name;
	private String ur_email;
	private Date ur_birth_date;
	private Date ur_reg_date;
	
	// 기본 생성자
    public MemberDTO() { //값이 없으면 죄다 null
    	this.ur_no = 0;
    	this.ur_id = null; 
        this.ur_passwd = null; 
        this.ur_name = null; 
        this.ur_email = null; 
        this.ur_birth_date = null;
        this.ur_reg_date = null;
        
    }

    // 매개변수를 받는 생성자
    public MemberDTO(int ur_no, String ur_id, String ur_passwd, String ur_name, String ur_email, Date ur_birth_date, Date ur_reg_date) {
        this.ur_no = ur_no;
        this.ur_id = ur_id;
        this.ur_passwd = ur_passwd;
        this.ur_name = ur_name;
        this.ur_email = ur_email;
        this.ur_birth_date = ur_birth_date;
        this.ur_reg_date = ur_reg_date;
    }
	//getters
	public int getUr_no() {
        return ur_no;
    }

    public String getUr_id() {
        return ur_id;
    }

    public String getUr_passwd() {
        return ur_passwd;
    }

    public String getUr_name() {
        return ur_name;
    }

    public String getUr_email() {
        return ur_email;
    }

    public Date getUr_birth_date() {
        return ur_birth_date;
    }

    public Date getUr_reg_date() {
        return ur_reg_date;
    }

    // Setter 메서드들
    public void setUr_no(int ur_no) {
        this.ur_no = ur_no;
    }

    public void setUr_id(String ur_id) {
        this.ur_id = ur_id;
    }

    public void setUr_passwd(String ur_passwd) {
        this.ur_passwd = ur_passwd;
    }

    public void setUr_name(String ur_name) {
        this.ur_name = ur_name;
    }

    public void setUr_email(String ur_email) {
        this.ur_email = ur_email;
    }

    public void setUr_birth_date(Date ur_birth_date) {
        this.ur_birth_date = ur_birth_date;
    }

    public void setUr_reg_date(Date ur_reg_date) {
        this.ur_reg_date = ur_reg_date;
    }
    
    //toString
    @Override
    public String toString() {
        return "MemberDTO{" +
                "ur_no=" + ur_no +
                ", ur_id='" + ur_id + '\'' +
                ", ur_passwd='" + ur_passwd + '\'' +
                ", ur_name='" + ur_name + '\'' +
                ", ur_email='" + ur_email + '\'' +
                ", ur_birth_date=" + ur_birth_date +
                ", ur_reg_date=" + ur_reg_date +
                '}';
    }
}
