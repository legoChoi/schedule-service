## API 명세서 - by Postman
일정
https://documenter.getpostman.com/view/25817958/2sAYBd88iM


유저

https://documenter.getpostman.com/view/25817958/2sAYBd88iN


## 요구 사항 
SPRING, JDBC, MYSQL을 사용한 API 구현

기능
- 레벨 1
  - 일정 생성
  - 전체 일정 조회
  - 선택 일정 조회
- 레벨 2
  - 일정 수정
  - 일정 삭제
- 레벨 3
  - 연관 관계 설정(회원 - 일정 관계)
- 레벨 4
  - 페이지 네이션 (오프셋 기반)
- 레벨 5
  - 예외 처리 @ExceptionHanlder
- 레벨 6
  - @Valid 사용한 validation 구현


## ERD
![일정_게시판_ERD](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbSmEWs%2FbtsLdh9rlkM%2FuewAk1daFH6RejsUK8kUg1%2Fimg.png)

## 폴더 스트럭쳐
![일정_게시판_폴더_스트럭쳐](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FO25bh%2FbtsLcMWuFmp%2FNIaPSKjPAgPYmtAXzJwYiK%2Fimg.png)

## 추가 계획
- 계층간 DTO, DAO 사용 분리