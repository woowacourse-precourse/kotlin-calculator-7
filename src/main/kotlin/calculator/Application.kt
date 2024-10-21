package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    try {
        println("덧셈할 문자열을 입력해 주세요.")
        val input = Console.readLine()
        val result = add(input)
        println("결과 : $result")
    } catch (e: IllegalArgumentException) {
        println("에러 발생: ${e.message}")
    }
}

fun add(input: String): Int {
    if (input.isBlank()) {
        return 0
    }

    val delimiter = if (input.startsWith("//")) {
        val customDelimiterEnd = input.indexOf("\n")
        val customDelimiter = input.substring(2, customDelimiterEnd)
        val numbers = input.substring(customDelimiterEnd + 1)
        return splitAndSum(numbers, customDelimiter)
    } else {
        return splitAndSum(input)  // 계산된 값을 반환
    }
}

fun splitAndSum(input: String, delimiter: String = "[,|:]"): Int {
    val numbers = input.split(Regex(delimiter))
        .map { it.toIntOrNull() ?: throw IllegalArgumentException("잘못된 숫자가 포함되어 있습니다.") }
    return numbers.sum()  // 숫자들의 합을 반환
}
