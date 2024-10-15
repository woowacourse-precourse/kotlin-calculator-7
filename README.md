# kotlin-calculator-precourse

## 🚀 미션 설명
- 문자열을 입력받아 구분자와 커스텀 구분자를 사용해 숫자를 추출하여 합을 구하는 간단한 덧셈 계산기

## 🛠️구현할 기능 목록

1. 제공된 콘솔 API를 이용하여 문자열 입력 받기
    - `camp.nextstep.edu.missionutils`에서 제공하는 `Console` API를 사용
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용

2. 커맨드를 검증하여 구분자 Set 생성
    - 커스텀 구분자를 식별하기 위한 `// \n`를 포함한 5자리 문자열을 **커맨드**로 정의
    - 기본 구분자 ,와 :을 구분자 Set에 추가하기
    - 커맨드를 검증한 뒤 정상 커맨드일 경우 커스텀 구분자를 구분자 Set에 추가하기

4. 구분자를 이용해 슬라이싱 하여 합을 구하고 출력하기
    - 2번에서 구한 구분자를 이용해 슬라이싱
    - Int형으로 변환 후 전부 더하여 출력하기

5. 잘못된 값 입력을 예외 처리하기
    - `IllegalArgumentException`을 발생시키고 애플리케이션 종료하기