# kotlin-calculator-precourse

# 📃문자열 덧셈 계산기 기능 목록
## 출력
- [x] 문자열 입력 요청 문구 출력
- [x] 입력된 문자열에 따른 결과 출력

## DelimiterSplitter 구분자분리기
- [x] 문자열 유효성 검사
  - [x] 커스텀 구분자 사용 선언 포맷 확인
    - 포맷이 올바르지 않다면  ``` IllegalArgumentException```을 발생시킨다.
  - [x] 구분 이후 모두 양수 인지 확인
    - 양수는 0 이상의 실수를 의미한다
    - 양수 이외의 값이 확인된다면 ``` IllegalArgumentException```을 발생시킨다.
- [x] 커스텀 구분자 사용 여부 확인
- [x] 커스텀 구분자 찾기
- [x] 지정된 구분자를 이용하여 문자열 구분

## SumCalculator 구분된 결과 덧셈 계산기 
- [x] 구분된 결과를 보고 합계 계산
  - 결과 범위는 제한하지 않는다.

## ResultFormatter 덧셈 결과 형식 맞춤기
- [x] 결과를 일반적인 숫자 포맷팅

## IllegalArgumentException 발생 시 애플리케이션은 종료되어야 한다.