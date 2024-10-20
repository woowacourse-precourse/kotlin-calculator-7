package calculator

class Controller(private val validator: Validator) {

    // 입력을 처리하고 최종 합산 결과를 반환
    fun calculate(input: String): Int {
        if (input.isBlank()) return 0

        // 구분자와 숫자 부분을 추출
        val (numbers, delimiters) = parseInput(input)

        // 숫자들을 분리하고 합산
        return splitAndSum(numbers, delimiters)
    }

    // 입력에서 숫자 부분과 구분자를 추출하는 함수
    fun parseInput(input: String): Pair<String, String> {
        return if (input.startsWith("//")) {
            // 커스텀 구분자 처리
            parseCustomDelimiterInput(input)
        } else {
            // 기본 구분자 처리
            parseDefaultDelimiterInput(input)
        }
    }

    // 커스텀 구분자가 있는 입력을 처리하는 함수
    fun parseCustomDelimiterInput(input: String): Pair<String, String> {
        val delimiterEndIndex = input.indexOf("\n")
        validator.validateDelimiterFormat(delimiterEndIndex)

        val customDelimiter = extractCustomDelimiter(input, delimiterEndIndex)
        val numberPart = extractNumberPart(input, delimiterEndIndex)
        return Pair(numberPart, customDelimiter)
    }

    // 기본 구분자(쉼표, 콜론)를 처리하는 함수
    fun parseDefaultDelimiterInput(input: String): Pair<String, String> {
        return Pair(input, "[,:]") // 쉼표와 콜론을 기본 구분자로 사용
    }

    // 커스텀 구분자를 추출하는 함수
    fun extractCustomDelimiter(input: String, delimiterEndIndex: Int): String {
        val customDelimiter = input.substring(2, delimiterEndIndex)
        validator.validateCustomDelimiter(customDelimiter)
        return customDelimiter
    }

    // 숫자 부분을 추출하는 함수
    fun extractNumberPart(input: String, delimiterEndIndex: Int): String {
        return input.substring(delimiterEndIndex + 1)
    }

    // 숫자들을 구분자에 따라 분리하고 합산하는 함수
    fun splitAndSum(numbers: String, delimiters: String): Int {
        return numbers
            .split(Regex(delimiters))  // 구분자로 숫자 분리
            .map { validator.validateNumber(it) }  // 각각을 Int로 변환 (유효하지 않으면 예외 발생)
            .sum()  // 합산
    }
}