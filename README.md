# kotlin-calculator-precourse

### ✅ 구현할 기능 목록
1. 사용자 입력
   - [x] `camp.nextstep.edu.missionutils.Console`의 `readLine()`를 사용해 사용자 입력을 받음
2. 구분자 리스트
   - [x] 문자열 앞 부분에 커스텀 구분자가 정의되어있는지 확인("//", "\n" 사이의 문자)
   - [x] 구분자 리스트에 기본 구분자, 커스텀 구분자 추가하기
3. 숫자 추출
   - [x] 구분자를 기준으로 값을 분리(이때 각 값들의 타입은 문자열)
   - [x] 문자열을 숫자로 변환하기
     - [x] 숫자로 변환할 수 없는 경우 `IllegalArgumentException` 발생 후 종료
       - 숫자가 아닌 경우
       - 기본/커스텀 이외의 구분자가 포함되어있는 경우
4. 합 계산
   - [x] 숫자에 음수가 존재하면 `IllegalArgumentException` 발생 후 종료
   - [x] 숫자들의 합을 계산 후 리턴
