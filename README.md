# 토이 프로젝트 - 간단한 게시판 및 JWT 인증

## 개요
- Spring Boot를 활용한 간단한 CRUD 게시판 Toy Project
- REST API를 이용한 데이터 통신
- Spring Security를 활용한 JWT(JSON Web Tokens) 인증 방식 구현




## 주요 기능
- 게시판에서 게시물 작성, 조회, 수정, 삭제 가능
- JWT를 이용한 사용자 인증
- JWT 권한으로 API 엔드포인트 보호
- 간단한 사용자 인터페이스를 위한 HTML, Bootstrap, jQuery 사용




## 사용된 기술 스택
- **Spring Boot**: Java 기반의 백엔드 프레임워크
- **MyBatis**: SQL 매핑을 통한 관계형 데이터베이스 상호 작용
- **JWT (JSON Web Tokens)**: API 엔드포인트 보호를 위한 토큰 기반 인증
- **HTML, Bootstrap, jQuery**: 간결하면서도 세련된 프론트엔드 구성




## 비즈니스 로직
1. **회원가입**: 사용자 정보를 입력하고 회원가입 진행
2. **로그인**: 인증을 통해 JWT 토큰 발급 및 로그인 진행, 성공 시 게시판으로 이동
3. **게시판 접근**: JWT Filter를 통해 토큰 확인, 토큰 없을 시 Spring Security에서 접근 거부
4. **게시판 CRUD**: 로그인 상태에서 게시물 작성, 조회, 수정, 삭제 가능



###Detial 설명
