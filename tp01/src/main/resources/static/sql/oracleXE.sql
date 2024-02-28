CREATE SEQUENCE tp01_seq_ur_no
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
    
CREATE SEQUENCE tp01_seq_bd_no
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
    
CREATE TABLE TP01BOARD (
    bd_no INT DEFAULT tp01_seq_bd_no.NEXTVAL PRIMARY KEY,
    ur_no INT NOT NULL,
    ur_name VARCHAR(255) NOT NULL,
    bd_name VARCHAR(255) NOT NULL,
    bd_info VARCHAR(1000) NOT NULL,
    bd_type VARCHAR(255) NOT NULL,
    bd_auth INT DEFAULT 4,
    bd_hit INT DEFAULT 0,
    bd_reg_date DATE DEFAULT SYSDATE
);

CREATE TABLE TP01MEMBER (
    ur_no INT DEFAULT tp01_seq_ur_no.NEXTVAL PRIMARY KEY,
    ur_id VARCHAR(255) NOT NULL,
    ur_passwd VARCHAR(255) NOT NULL,
    ur_name VARCHAR(255),
    ur_email VARCHAR(255),
    ur_birth_date DATE,
    ur_reg_date DATE DEFAULT SYSDATE
)