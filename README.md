# Membership Management Service(회원 관리 프로그램)

## Description

- 사용자가 입력한 회원 정보를 데이터베이스에 저장하고, 저장된 정보를 관리할 수 있는 프로그램이다.
  - 회원 정보를 등록, 수정, 삭제, 조회할 수 있다.

## Environment
- Window11
- 
- H2 database
- Java

## Files
- MainClass
  - 회원 관리 프로젝트를 실행시키는 클래스이다.
- MemberDAO
  - DB와의 연결을 통해 CRUD 메소드가 들어있는 클래스이다.
- MemberManager
  - 회원 정보를 입력받고 유효성 검사 후 MemberDAO를 통해 DB에 저장하고, 수정, 삭제 기능을 하는 클래스이다.
- Utility
  - DB와의 연결, 연결해제 메소드가 있는 클래스이다.

## Usage
- h2.jar 파일이 ClassPath에 추가가 되어있는지 확인한다.
  - 추가방법은 다음 [링크](https://velog.io/@zz1996zz/JDBC)를 참고한다.
- 추가 후에 H2 database가 설치된 위치에 bin폴더안의 h2w.bat파일을 실행시켜 DB 엔진을 실행시킨다.
- 실행 후에 MainClass를 실행시키면 프로그램이 동작한다.
