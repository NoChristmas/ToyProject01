# 토이 프로젝트 - 간단한 게시판 및 JWT 인증

## 개요
- SpringBoot를 이용한 간단한 CRUD 게시판 만들기 ToyProject
- RESTAPI 이용
- Spring Security를 사용한 JWT 인증 방식
  
## 기능
- 게시판에서 게시물 작성, 조회, 수정, 삭제 가능.
- JWT를 사용한 사용자 인증.
- JWT 권한으로 API 엔드포인트를 보호.
- 간단한 사용자 인터페이스를 위한 HTML, Bootstrap, jQuery 사용.

## 사용된 기술
- **Spring Boot**: Java 기반 애플리케이션 개발을 위한 백엔드 프레임워크.
- **MyBatis**: 관계형 데이터베이스와 상호 작용하기 위한 SQL 매핑 프레임워크.
- **JWT (JSON Web Tokens)**: API 엔드포인트를 보호하기 위한 토큰 기반 인증.
- **HTML, Bootstrap, jQuery**: 간단한 사용자 인터페이스를 위한 프론트엔드 기술.

## Business Logic
- 회원가입 
- 로그인 -> JWT 토큰 발급 -> 게시판 이동
- 게시판 Controller 접근 시 JWT Filter로 토큰 확인 **Token 없을 시 SpringSecurity로 deny**
- 나머지 게시판 CRUD
