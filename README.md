# kotlin-calculator-precourse

## 기능 목록

1. 커스텀 구분자를 제외한 입력에서의 계산기 기능 구현
   - Int 형의 범위를 벗어나는 숫자가 들어오는 경우는 없을 것이라고 판단하였다.
   
2. 커스텀 구분자 추가하는 기능구현
   - 커스텀 구분자는 한 글자이고, 하나만 추가할 수 있다고 생각하였음.
   
3. 예외처리 (IllegalException)
   - 커스텀구분자를 받는 문자열을 제외한 입력에서 구분자나 숫자가 아닌 문자가 있을 시 에러 발생
   
4. 예외처리 추가 및 리팩토링
   - 커스텀구분자가 숫자일 시 에러 발생
   - 연산자 전후에 숫자가 들어오지 않은 경우 에러 발생
   - 커스텀 연산자를 추가할 시, 기본 연산자는 사용하지 못하도록 변경
   - 기능을 함수로 분리