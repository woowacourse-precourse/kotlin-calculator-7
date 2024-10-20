package calculator

import camp.nextstep.edu.missionutils.Console


fun main() {
    // 문자열 입력받기
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()

    // 합을 계산하는 함수 호출
    val result = calculateSum(input)
    println("결과 : $result")
}

// 숫자들의 합을 계산하는 함수
fun calculateSum(input: String): Int {
    // 반환된 숫자 배열의 합을 계산
    val numbers = extractNumbers(input).mapNotNull { it.toIntOrNull() }
    return numbers.sum()
}

// 커스텀 구분자 사용 여부 확인 함수
fun isCustomDelimiter(input: String): Boolean {
    return input.startsWith("//")
}

// 유효한 커스텀 구분자를 추출하고 지정하는 함수
fun extractCustomDelimiter(input: String): Pair<String, String> {
    // "\n"이 있는 지 확인
    if (input[3] == '\\' && input[4] == 'n') {
        // 구분자를 추출
        val delimiter = input.substring(2, 3)
        val numbersPart = input.substring(5)  // 숫자 부분 추출

        // 숫자 제외 모든 문자 가능 여부 확인
        val isValidDelimiter = delimiter.all { it !in '0'..'9' }

        // 구분자가 유효한 경우
        if (isValidDelimiter) {
            return Pair(delimiter, numbersPart)
        } else {
            throw IllegalArgumentException("유효한 구분자가 아닙니다.")
        }
    }
    throw IllegalArgumentException("유효한 커스텀 구분자가 없습니다.")
}

// 구분자로 계산할 숫자를 추출하는 함수
fun extractNumbers(input: String): List<String> {
    val numbers: List<String>

    // 커스텀 구분자 유무 판단
    if (isCustomDelimiter(input)) {
        // 커스텀 구분자 추출
        val (delimiter, numbersPart) = extractCustomDelimiter(input)

        // 구분자와 ",", ":"로 분할
        numbers = numbersPart.split(delimiter, ",", ":")
    } else {
        // [ , : ]로 분할
        numbers = input.split("[,:]".toRegex())
    }
    validateNumbers(numbers)
    return numbers
}

// 숫자의 유효성을 검사하는 함수
fun validateNumbers(numbers: List<String>) {
    numbers.forEach {
        // 구분자가 연속되어 입력되는 경우 & 입력값이 비어있을 경우
        if (it.isEmpty()) {
            throw IllegalArgumentException("잘못된 입력값입니다.")
        }

        // 숫자와 구분자 이외에 다른 값이 입력된 경우
        if (!it.all { char -> char.isDigit() }) {
            throw IllegalArgumentException("숫자와 구분자 이외에 다른 값이 입력되었습니다.")
        }

        // 더해야 할 값에 음수가 있는 경우
        val number = it.toIntOrNull()
        if (number == null || number < 0) {
            throw IllegalArgumentException("음수는 허용되지 않습니다.")
        }
    }
}