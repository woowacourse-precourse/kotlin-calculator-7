# kotlin-calculator-precourse

---

## 구현할 기능 목록
- 입력
  - Console.readLine() 메소드를 통해 받은 String을 return
- 문자열 유효성 검사
  - 허용되는 문자만을 사용했는지 문자열 길이 만큼 선형 탐색
- 숫자 추출
  - split(), map() 메소드를 통해 숫자 분리 후 List를 return
- 연산
  - List.sum() 반환
- 출력
  - 결과 출력

### 리팩토링으로 추가한 기능
- 커스텀 구분자 유무 확인
  - val regex = Regex("^//.\\\\n")
  - 문자열이 정규 표현식이랑 일치하는지 확인하고 Boolean을 return