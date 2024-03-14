# 토이 프로젝트 - 간단한 게시판 및 JWT 인증

## 개요
- Spring Boot를 활용한 간단한 CRUD 게시판 Toy Project
- REST API를 이용한 데이터 통신
- Spring Security를 활용한 JWT(JSON Web Tokens) 인증 방식 구현
- 다중 DB 연동하여 DB 분리 (Oracle, MongoDB)

## Version
- JDK 17
- SpringBoot 3.2.2
- mybatis 3.X
- jjwt 0.9.1

## 주요 기능
- RESTAPI 게시판 CRUD
- NoSQL MongoDB, RDBMS Oracle XE연동 (JPA, MyBatis)
- Spring Security를 이용한 보안 설정, JWT를 이용한 사용자 인증 (Filter) API 엔드포인트 보호
- 간단한 사용자 인터페이스를 위한 JSP, jQuery사용

## 사용된 기술 스택
- **Spring Boot**: Java 기반의 백엔드 프레임워크
- **MyBatis, JPA**: SQL 매핑을 통한 관계형 데이터베이스 상호 작용
- **JWT (JSON Web Tokens)**: API 엔드포인트 보호를 위한 토큰 기반 인증
- **HTML, jQuery**: 간결하면서도 세련된 프론트엔드 구성
- **Spring Security**: 허용되지 않은 End-Point 보호
- **MongoDB, OracleXE 연동**: 여러 DB를 연동하여 사용


## 비즈니스 로직
1. **회원가입**: 사용자 정보를 입력하고 회원가입 진행
2. **로그인**: 인증을 통해 JWT 토큰 발급 및 로그인 진행, 성공 시 게시판으로 이동
3. **게시판 접근**: JWT Filter를 통해 토큰 확인, 토큰 없을 시 Spring Security에서 접근 거부
4. **게시판 CRUD**: 로그인 상태에서 게시물 작성, 조회, 수정, 삭제 가능 (Oracle)
5. **로그 생성**: 사용자 접속시 로그 생성하여 DB 저장 (MongoDB)

## 블로그 : https://velog.io/@nochristmas/posts
