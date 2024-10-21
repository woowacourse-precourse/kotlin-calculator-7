package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // 사용자 입력
    println("덧셈할 문자열을 입력해 주세요.")
    val userInput = Console.readLine() ?: ""

    // 입력이 비어있으면 0 출력
    if (userInput.isBlank()) {
        println("결과: 0")
        return
    }
}
