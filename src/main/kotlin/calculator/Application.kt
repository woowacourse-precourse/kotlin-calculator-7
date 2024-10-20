package calculator

import calculator.add

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = readLine() ?: ""

    try {
        val result = add(input)

        // 결과 소수점 구분 출력 로직
        if (result == result.toInt().toDouble()) {
            println("결과 : ${result.toInt()}")
        } else {
            println("결과 : $result")
        }
    } catch (e: IllegalArgumentException) {
        throw IllegalArgumentException()
    }
}