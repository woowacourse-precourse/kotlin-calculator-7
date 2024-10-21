package calculator

import java.lang.IllegalArgumentException

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = readLine() ?: ""

    try {
        ValidData.validNumbers = StringValidator().checkValidString(input).toMutableList()
        val result = Calculator.sumNumbers()
        println("결과 : $result")
    } catch (e: IllegalArgumentException) {
        println("${e.message}")
        throw e
    }
}
