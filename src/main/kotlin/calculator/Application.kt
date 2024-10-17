package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine() ?: ""
    val result = add(input)
    println("결과 : $result")
}

fun add(input: String?): Int {
    if (input.isNullOrEmpty()) { // 빈 문자열 또는 null 입력할 경우 0 반환
        return 0
    }
    val numbers = parseNumbers(input)
    return numbers.sum()
}

fun parseNumbers(input: String): List<Int> {
    var delimiters = listOf(",", ":") // 쉼표와 콜론을 구분자로 설정
    var numbersSection = input

    if (input.startsWith("//")) {
        val delimiterEnd = input.indexOf("\\n")
        if (delimiterEnd == -1) {
            throw IllegalArgumentException("커스텀 구분자 지정이 잘못되었습니다.")
        }
        val customDelimiter = input.substring(2, delimiterEnd)

        if (customDelimiter.isEmpty()) {
            throw IllegalArgumentException("커스텀 구분자가 빈 문자열입니다.")
        }

        delimiters = listOf(Regex.escape(customDelimiter))// 커스텀 구분자 설정
        numbersSection = input.substring(delimiterEnd + 2) // 숫자 부분 추출
    }
    val tokens = numbersSection.split(Regex(delimiters.joinToString ("|"))) // 구분자를 기준으로 숫자 분리
        .filter { it.isNotBlank() } // 구분자 뒤 공백이 올 경우 무시하고 값 처리

    return tokens.map {
        val number = it.trim() //리스트의 공백 제거(ex:1, 2, 3을 입력 할 경우 공백 제거되서 6 반환)

        if (number.isEmpty()) {
            0 // 빈 문자열이 있을 경우 0으로 처리

        } else { // 숫자가 아닌 값이나 음수에 대한 예외 처리
            val num = number.toIntOrNull() ?: throw IllegalArgumentException("유효한 숫자가 아닙니다.")

            if (num < 0) {
                throw IllegalArgumentException("음수는 허용되지 않습니다.")
            }
            num // 예외 조건을 통과할 경우 수 반환
        }
    }
}