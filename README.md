# kotlin-calculator-precourse

## 1주차: 문자열 덧셈 계산기

---

- 코틀린 공식 컨벤션 https://kotlinlang.org/docs/coding-conventions.html
- 커밋 메시지 컨벤션 https://gist.github.com/stephenparish/9941e89d80e2bc58a153

---
구분자와 양수로 구성된 문자열에서 구분자를 기준으로 분리한 각 숫자의 합을 반환하는 계산기를 구현한다.

## 기능 요구사항

---
- 쉼표(,) 와 콜론(:) 을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
- "//" 와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 을 발생시킨 후에 애플리케이션을 종료시켜야 한다.

## 세부 기능 목록


### 메인 함수 로직
1. 문자열을 입력받는다.
2. 문자열이 유효한지 확인한다.
3. 문자열을 Calculator 클래스에 계산한다.

### Calculator 클래스
유효한 문자열에 대해서만 계산한다.
-[x] 커스텀 구분자가 있다면 커스텀 구분자를 구분자에 추가하고, 문자열을 분리한다.
-[x] 문자열의 구분자를 기준으로 각 숫자들을 분리해 리스트에 저장한다.
-[x] 구분자를 기준으로 분리된 리스트의 요소들의 총 합을 구한다.
-[x] 결과를 출력한다.

### Validator 클래스
-[x] 문자열 유효성을 검증한다.
-[x] 문자열의 커스텀 구분자를 확인한다.

### 문자열 유효성 검증 방법
-[x] 각 문자가 '0' ~ '9' 혹은 기본 구분자( , : ) 인가 ?
-[x] 첫 두 문자가 "//" 일 때, 3번째 문자는 숫자가 아니고, 4, 5번째 문자가 각각 '\', 'n' 인가 ?

## 기능 개선 사항
### 1. 앞 5문자의 유효성 검증 및 커스텀 구분자 반환 기능

- 앞 5문자의 유효성을 검증하는 기능
- 커스텀 구분자가 있다면 반환하는 기능

위 두가지 기능이 `validateCustomDelimiter()` 함수에 같이 있다.

그렇기 때문에 Calculator 클래스에서 커스텀 구분자를 얻어 오기 위해 `validateCustomDelimiter()` 함수를 호출하면, 불필요한 앞 5문자의 유효성을 다시 검증한다.
따라서 두 기능을 분리해 함수화시켜야 한다.

추가적으로 로직의 편의성을 위해서 커스텀 구분자만 반환하는 게 아닌, 그냥 구분자 전체를 반환하도록 함으로써
Calculator 클래스에서는 그냥 받기만 하도록 한다.
```kotlin
// 변경 전
fun validateCustomDelimiter(inputString: String): String { ... }
// 변경 후
fun validatePrecedingString(inputString: String): String { ... }
fun getDelimiter(inputString: String): String { ... }
```

### 2. `validateString()` 함수의 로직 개선 및 가독성 개선

- 문자열의 커스텀 구분자 부분의 유효성을 검증한다.
- 문자열의 남은 부분의 유효성을 검증한다.
```kotlin
fun validateString(inputString: String): String {
    // 변경 후
    val checkString = validatePrecedingString(inputString)
        .validateRemainingString()
    return checkString
}
```
외부에서 실행하는 함수(`validateString()`)는 최대한 간단하게 한 후에, 기능을 내부 함수로 위임한다.