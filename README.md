# IIShop project

스프링부트, JPA로 구현한 패션정보 사이트

## 개발환경
- intellij
- Github
- h2

## 사용기술
### 백엔드
#### 주요 프레임워크 / 라이브러리
- Java17
- SpringBoot 3.2.2

#### Build tool
- gradle

#### Database
- h2

### 프론트엔드
- Html
- Thymleaf
- Bootstrap5

### 기타 라이브러리
- Lombok

## 목표
- 스프링부트, JPA를 사용하여 웹 애플리케이션 전반적인 기획
- 백엔드 개발의 전과정 운영 경험
- MVC 프레임워크 기반으로 백엔드 서버를 구축

## 프로젝트 구현 기능
### 회원 (Member)
- 회원가입 / 로그인 및 로그아웃

### 상품 (Item)
- 상품 등록 / 상품 관리 / 상품 수정 / 상품 조회 (메인화면) / 상품 상세 페이지

### 찜 (Heart)
- 찜하기 / 찜 목록 조회 / 찜 삭제

## 프로젝트 구조



## ERD구조
![Entity Relationship Diagram for Enrollment System](https://github.com/usingjun/simple-fashionInfo-project/assets/97494494/07dd64dc-4dac-40ed-b1cc-807bcb167c7e)

## 프로젝트 API 명세서
Function	Method	End Point
- 상품 등록 페이지	Get	/item/new
- 상품 등록	Post	/item/new
- 상품 조회	Get	/item, /item/{itemId}, /item/{page}
- 상품 수정 페이지	Get	/item/{itemId}/edit
- 상품 수정	Post	/item/{itemId}/edit
- 로그인 페이지	Get	/member/login
- 로그인	Post	/member/login
- 회원 가입 페이지	Get	/member/new
- 회원 가입	Post	/member/new
- 찜 페이지	Get	/heart
- 찜 삭제	Delete	/heart/{heartId}
