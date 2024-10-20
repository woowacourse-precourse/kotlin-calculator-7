package calculator

import camp.nextstep.edu.missionutils.Console

private const val INPUT_SUM_STRING_MESSAGE = "덧셈할 문자열을 입력해 주세요."

fun main() {
    println(INPUT_SUM_STRING_MESSAGE)
    val input = Console.readLine().trim()

    if (input.isBlank()) {
        println(0)
        return
    }
}
