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

## 리팩토링으로 추가한 기능
- 커스텀 구분자 유무 확인
  - val regex = Regex("^//.\\\\n")
  - 문자열이 정규 표현식이랑 일치하는지 확인하고 Boolean을 return

## 예외 처리

1. 커스텀 구분자만 온 경우

![e1](https://github.com/user-attachments/assets/98e984d6-eb28-4328-96a0-3ed60c58a389)


2. 커스텀 구분자가 마지막에 온 경우

![e2](https://github.com/user-attachments/assets/ce6b0a59-5489-4c11-861e-6c47e461c156)

3. 구분자가 처음에 온 경우

![e3](https://github.com/user-attachments/assets/bb9cdcb1-539b-479c-9559-6597acb7f9bf)


4. 빈 문자열이 온 경우

![e4](https://github.com/user-attachments/assets/4fc5fc12-2f29-4ce6-8dfc-a773ce852f87)

## 빌드 테스트

![image](https://github.com/user-attachments/assets/8b230aac-5097-4491-a42a-2ea1664f6e75)
