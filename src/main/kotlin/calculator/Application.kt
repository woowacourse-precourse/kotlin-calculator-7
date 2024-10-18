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

    val delimiters = listOf(",", ":")
    val numbers = input.split(*delimiters.toTypedArray())

    return numbers.mapNotNull { it.toIntOrNull() }.sum()
}