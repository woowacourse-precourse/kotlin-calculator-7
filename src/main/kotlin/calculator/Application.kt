package calculator

import java.lang.IllegalArgumentException

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = readLine() ?: ""

    try {
        // 유효성 검사 및 숫자 리스트 반환 후 ValidData에 저장
        ValidData.validNumbers = StringValidator().checkValidString(input).toMutableList()
        // 합산 계산
        val result = Calculator.sumNumbers()
        println("결과 : $result")
    } catch (e: IllegalArgumentException) {
        println("${e.message}")
    }
}
