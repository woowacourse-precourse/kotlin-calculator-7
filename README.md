# kotlin-calculator-precourse
## 기능 목록
1. camp.nextstep.edu.missionutils 라이브러리 임포트
    - Console API 사용하여 구현
    - camp.nextstep.edu.missionutils.Console 의 readLine() 활용해 입력받기
2. 구분자 ',', ':' 두가지를 기준으로 분리
    - 방법 1: 구분자로 나누어 구분
    - 방법 2: 문자열에서 숫자만 필터링
3. 구분한 값의 합 저장
4. 출력 형식 지정
    - 덧셈할 문자열을 입력해 주세요.
    - (입력값)
    - 결과 : (합)
5. 커스텀 구분자 "//", "\n" 사이에 위차한 문자를 커스텀 구분자로 사용
6. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 발생 후 종료
7. 테스트 케이스 추가
