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
- [x] 문자열 파싱
- [x] 덧셈 계산
- [x] 입력 및 출력 구현

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

### 문자열 파싱
```kotlin
class Parser {
    private var delimiter: Regex = Regex("[,:]")
    private var numbers: List<Int> = mutableListOf()

    fun parse(input: String): List<Int> {
        val numberPart = extractNumberPart(input)
        val customDelimiter = extractCustomDelimiter(input)

        if (customDelimiter != null) {
            delimiter = addCustomDelimiter(customDelimiter)
        }

        val rawNumbers = numberPart.split(delimiter)

        numbers = rawNumbers.map { it.toInt() }
        Validator.validateNegativeNumbers(numbers)

        return numbers
    }
}
```
- 검증된 문자열을 파싱합니다.
- 정규 표현식을 이용하여 구분자를 통해 문자열에서 숫자를 분리합니다.

### 덧셈 계산
```kotlin
class Calculator {
    fun calculate(numbers: List<Int>): Int {
        return numbers.sum()
    }
}
```
- 숫자 리스트를 인자로 받아 숫자들의 합을 계산합니다.

### 입력 및 출력
```kotlin
object InputView {
    private const val INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요."

    fun getUserInput(): String {
        println(INPUT_MESSAGE)
        return Console.readLine()
    }
}

object OutputView {
  private const val RESULT_MESSAGE = "결과 : "

  fun printResult(result: Int) {
    print(RESULT_MESSAGE + result)
  }
}
```
- 사용자 입력과 출력에 관한 `object`입니다.

### 컨트롤러
```kotlin
class CalculationController {
    fun start() {
        val userInput = getInput()
        val numbers = parseInput(userInput)
        val result = calculateResult(numbers)
        showResult(result)
    }

    private fun getInput(): String {
        val input = InputView.getUserInput()
        Validator.validateInput(input)
        return input
    }

    private fun parseInput(input: String): List<Int> {
        val parser = Parser()
        return parser.parse(input)
    }

    private fun calculateResult(numbers: List<Int>): Int {
        val calculator = Calculator()
        return calculator.calculate(numbers)
    }

    private fun showResult(result: Int) {
        OutputView.printResult(result)
    }
}
```
- `View`와 `Model` 사이에서 데이터를 교환하는 클래스입니다.
