package calculator

import java.lang.IllegalArgumentException

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = readLine() ?: ""

    try {
        val result = add(input)
        println("결과 : $result")
    } catch (e: IllegalArgumentException) {
        println("${e.message}")
    }
}

fun add(input: String): Int {
    // 기능1. 빈 문자열 입력 처리
    if (input.isEmpty()) {
        return 0
    }

    // 기능2. 기본구분자(쉼표 또는 콜론)를 구분자로 가지는 문자열 덧셈
    val delimiters = "[,:]"
    val numbers = input.split(Regex(delimiters))

    val validNumbers = numbers.map { it.toIntOrNull() ?: throw IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.") }

    return validNumbers.sum()
}
