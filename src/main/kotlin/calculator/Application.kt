package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")

    val input = try {
        Console.readLine()  // 입력값 받기
    } catch (e: Exception) {
        ""  // 예외 발생 시 빈 문자열로 처리
    }

    println(calculate(input))
}

fun calculate(input: String): String {
    if (input.isBlank()) return "결과 : 0"  // 빈 문자열 처리

    return "결과"
}
