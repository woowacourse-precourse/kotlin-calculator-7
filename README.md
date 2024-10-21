# kotlin-calculator-precourse
## 기능

1. 문자열 입력받기

- 사용자에게 문자열을 입력받기 위한 안내 메시지를 출력

2. 구분자 분해하기

- 기본 구분자는 콤마(,)와 콜론(:)

- 커스텀 구분자를 사용하려면 문자열의 맨 앞에 //[구분자]\n 형식을 사용

3. 숫자 분리 및 리스트 생성

- 입력된 문자열에서 구분자를 사용하여 숫자들을 분리

4. 숫자 유효성 검사 및 합 계산

- 숫자 리스트의 각 요소에 대해 유효성을 검사

5. 에러 처리

- 빈 문자열 입력 시: IllegalArgumentException 발생.

- 잘못된 구분자 형식 입력 시: IllegalArgumentException 발생.

- 음수 입력 시: IllegalArgumentException 발생.