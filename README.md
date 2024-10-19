# kotlin-calculator-precourse

## 기능 요구 사항
- , : 을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자합 반환
- 구분자 커스텀 가능. //, \n 사이에 위치하는 문자를 커스텀 구분자로 사용
- 잘못된 값 입력할 경우 IllegalArgumentException 발생 후 App 종료

## I/O 요구 사항
Input
- 구분자와 양수로 구성된 문자열
Output
- 덧셈 결과
![img.png](img.png)

## 기능 목록

### Calculator
- 숫자 합을 구하는 기능
- 결과를 리셋하는 기능 
### Extractor
- 구분자 제외한 숫자를 추출하는 기능
### InputView
- 문자열을 입력하는 기능
### OutputView
- 결과를 출력하는 기능
### Validator
- 음수가 포함돼 있는지 검증하는 기능
### CalculatorApp
- App을 실행하는 기능
- 입력을 시작하는 기능
- 검증을 시작하는 기능
- 계산을 시작하는 기능
- 결과 출력을 명령하는 기능
### Extensions
**String**
- 커스텀 구분자를 적용하지 않고 인트 리스트로 변환하는 기능
- 커스텀 구분자가 포함되어 있는지 확인하는 기능
- 커스텀 구분자를 포함해 split 하는 기능
- 커스텀 구분자를 적용해서 인트 리스트로 변환하는 기능

