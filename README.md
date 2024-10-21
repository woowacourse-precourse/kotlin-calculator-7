# 문자열 덧셈 계산기
## 기능 요구 사항
입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
  - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
  - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 입력
- 구분자와 양수로 구성된 문자열
### 출력
- 덧셈 결과
## 체크포인트
- [x] 입력 문자열 유효성 검사
- [ ] 문자열 파싱
- [ ] 덧셈 계산
- [ ] 입력 및 출력 구현

## 구현
### 유효성 검사
```kotlin
object Validator {
  fun validateInput(input: String) {
    if (input.startsWith("//")) {
      validateCustomDelimiterFormat(input)
      val customDelimiter = extractCustomDelimiter(input)
      validateCombineDelimiters(input, customDelimiter)
      return
    }
    validateDefaultDelimiter(input)
  }
}
```
- 커스텀 구분자가 입력된 경우와 그렇지 않은 경우를 나누었습니다.
- 커스텀 구분자가 입력된 경우
  - 커스텀 구분자 입력 형식을 검사합니다.
  - 입력된 문자열에 기본 구분자와 커스텀 구분자를 제외한 다른 특수문자가 포함되었는지 검사합니다.
- 커스텀 구분자가 입력되지 않은 경우
  - 입력된 문자열에 기본 구분자를 제외한 다른 특수문자가 포함되었는지 검사합니다.

```kotlin
    fun validateNegativeNumbers(numbers: List<Int>) {
        val negatives = numbers.filter { it < 0 }
        if (negatives.isNotEmpty()) {
            throw IllegalArgumentException(NEGATIVE_NUMBER_MESSAGE)
        }
    }
```
- 입력된 숫자가 음수인 경우를 처리하기 위해 작성한 메소드입니다.
- 다른 메소드들과는 다르게 숫자가 모두 파싱된 이후에 호출됩니다.
