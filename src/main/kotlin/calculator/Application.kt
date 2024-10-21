package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val strInput = Console.readLine()
    val result = addNumbers(strInput)
    println("결과: $result")
}

fun addNumbers(input: String): Int {
    val numbers = splitNumbers(input)
    return numbers.sumOf { it.toInt() }
}

fun splitNumbers(input: String): List<String> {
    return input.split(",", ";")
}