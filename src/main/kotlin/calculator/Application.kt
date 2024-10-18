package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")

    val inputString = Console.readLine()

    try {
        val result = sumNumbersInString(inputString)
        println("결과 : $result")
    } catch (e: IllegalArgumentException) {
        println("잘못된 입력입니다 : ${e.message}")
    }
}

fun sumNumbersInString(input: String): Int {
    if (input.isBlank()) return 0

    val numbers = splitByDelimiter(input)

    return numbers.sumOf { it.toIntOrNull() ?: throw IllegalArgumentException("유효한 숫자 또는 구분자를 입력하세요.") }
}

fun splitByDelimiter(input: String): List<String> {
    return if (input.startsWith("//")) {
        val delimiterAndNumbers = input.split("\\n", limit = 2)

        if (delimiterAndNumbers.size < 2) {
            throw IllegalArgumentException("구분자 형식이 잘못되었습니다. 형식은 '//[구분자]\\n[숫자와 구분자]'입니다.")
        }

        val customDelimiters = delimiterAndNumbers[0].substring(2)
        val numbers = delimiterAndNumbers[1]

        numbers.split(customDelimiters)
    } else {
        input.split(",", ":")
    }
}