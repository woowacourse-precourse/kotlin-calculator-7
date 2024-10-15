# kotlin-calculator-precourse

### ✅ 구현할 기능 목록
1. 사용자 입력
   - [ ] `camp.nextstep.edu.missionutils.Console`의 `readLine()`를 사용해 사용자 입력을 받음
2. 문자열 입력 확인
   - [ ] 잘못된 값 입력 시 `IllegalArgumentException` 발생 후 종료
     - 입력 값이 문자열이 아닌 경우
3. 구분자 확인
   - [ ] 문자열 앞 부분에 커스텀 구분자가 정의되어있는지 확인("//", "\n" 사이의 문자)
   - [ ] 구분자 리스트에 기본 구분자, 커스텀 구분자 추가하기
4. 숫자 분리
   - [ ] 구분자를 기준으로 값을 분리(이때 각 값들의 타입은 문자열)
   - [ ] 문자열을 숫자로 변환하기
     - [ ] 숫자로 변환할 수 없는 경우 `IllegalArgumentException` 발생 후 종료
       - 숫자가 아닌 경우
       - 기본/커스텀 이외의 구분자가 포함되어있는 경우
5. 숫자 계산
   - [ ] 숫자에 음수가 존재하면 `IllegalArgumentException` 발생 후 종료
   - [ ] 숫자들의 합을 계산 후 리턴
