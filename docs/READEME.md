## 기능 목록

---

## **Model (비즈니스 로직 및 데이터 처리)**

#### StringParser.kt (src/model/StringParser.kt)
- [x] 구분자(쉼표 `,`, 콜론 `:`)로 문자열을 분리한다.
- [x] 문자열에서 숫자를 추출하여 숫자 리스트로 반환한다.
- [x] 잘못된 입력이 있는 경우 **예외를 발생시킨다**.

#### SumCalculator.kt (src/model/SumCalculator.kt)
- [x] 추출된 숫자 리스트의 합을 계산하여 반환한다.
- [x] 빈 문자열이 입력된 경우 0을 반환한다.

---

## **View (결과 출력 및 사용자 입력)**

#### Input.kt (src/view/Input.kt)
- [x] 사용자로부터 **문자열**을 받는다.

#### OutputView.kt (src/view/OutputView.kt)
- [x] 덧셈 결과를 출력한다.

---

## **Controller (입력 처리 및 흐름 제어)**

#### CalculatorController.kt (src/controller/CalculatorController.kt)
- [x] **Input**을 통해 사용자로부터 입력을 받는다.
- [x] **StringParser**를 사용해 문자열을 파싱한다.
- [x] 파싱 중 잘못된 입력이 감지되면 **모델에서 던져진 예외를 처리**한다.
- [x] 파싱된 숫자 리스트를 **SumCalculator**를 통해 합계를 계산한다.
- [x] 계산된 결과를 **OutputView**를 통해 출력한다.

---

## **Main Application (프로그램 진입점)**

#### Application.kt (src/Application.kt)
- [x] 프로그램의 **진입점**으로서 실행된다.
- [x] **CalculatorController**를 초기화하고 프로그램을 시작한다.

---

### **주요 기능 흐름**
1. **사용자 입력 처리**:
    - **Input.kt**에서 사용자로부터 입력 문자열을 받는다.
2. **비즈니스 로직 처리**:
    - **Controller**가 **Model**에 문자열 파싱과 계산을 요청한다.
    - **Model**에서 유효성 검사를 하고, 문제가 있을 경우 **예외를 던진다**.
3. **결과 출력**:
    - **Controller**가 처리된 결과를 **OutputView**에 전달해 출력한다.
4. **예외 처리**:
    - 예외가 발생할 경우 **IllegalArgumentException**을 던진다.

---
## 프로그래밍 요구 사항
- [x] **Kotlin 1.9.24**에서 실행 가능해야 한다.
- [x] **Kotlin** 코드로만 구현한다.
- [x] **프로그램의 시작점**은 `Application의 main()` 메서드이다.
- [x] **build.gradle.kts** 파일은 수정하지 않는다.
- [x] **외부 라이브러리**는 사용하지 않는다.
- [x] 프로그램 종료 시 `System.exit()` 또는 `exitProcess()` 호출을 금지한다.
- [x] 파일 및 패키지의 이름을 변경하거나 이동하지 않는다.
- [x] **Kotlin Style Guide**를 따른다.

### 추가
- [ ] 함수의 길이는 **15라인** 이하로 유지한다.
- [ ] `else`문을 **지양**한다.
