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
    throw IllegalArgumentException("입력된 문자열이 유효하지 않습니다.")
}

