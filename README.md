### 프로젝트 개요

* 주제 : 식물 관리 및 성장 기록 시스템 개발

* 목표 : 사용자가 식물을 관리하고, 성장 데이터를 추적할 수 있도록 도와주는 웹 기반 애플리케이션. 이를 통해 사용자는 각 식물의 물 주기, 비료 주기, 환경조건 등을 기록하여 식물의 건강한 성장을 기록.


### 개발 환경 및 아키텍처

* 아키텍처 : 클라이언트-서버(client-server) 방식
* 접근 방식 : 웹 브라우저(web-browser) 기반 시스템
* 프론트엔드 : HTML, CSS, JavaScript 를 활용한 기본적인 UI/UX 설계
* 백엔드 : Java를 사용한 서버와 클라이언트 간의 로직 처리
* 데이터베이스 : MySQL
* 연동 기술 : JDBC를 통한 Java와 데이터베이스의 연결


### 기능 요구사항
* 식물 정보 관리
  + 새로운 식물 정보 등록 및 수정
  + 특정 식물의 세부 정보 조회
  + 불필요한 식물 정보 삭제
* 물 주기 스케줄 관리
  + 식물마다의 권장 물 주기와 마지막으로 물을 준 날짜 입력
  + 최근 물을 준 날짜 갱신
