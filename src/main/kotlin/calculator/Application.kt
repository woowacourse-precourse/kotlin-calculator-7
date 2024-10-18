package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")

    val inputString = Console.readLine()
    val result = sumNumbersInString(inputString)

    println("결과 : $result")
}

fun sumNumbersInString(input: String): Int {
    if (input.isBlank()) return 0

    val numbers = splitByDelimiter(input)

    return numbers.mapNotNull { it.toIntOrNull() }.sum()
}

fun splitByDelimiter(input: String): List<String> {
    return if (input.startsWith("//")) {
        val delimiterAndNumbers = input.split("\\n", limit = 2)

        val customDelimiters = delimiterAndNumbers[0].substring(2)
        val numbers = delimiterAndNumbers[1]

        numbers.split(customDelimiters)
    } else {
        input.split(",", ":")
    }
}