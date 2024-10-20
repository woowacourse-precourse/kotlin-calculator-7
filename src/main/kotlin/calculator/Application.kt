package calculator

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    println(MESSAGE_FOR_GUIDE_CALCULATE)
    val userInput = readLine()

    checkInputIsEmpty(userInput)
}

private fun checkInputIsEmpty(input: String) {
    if (input.isEmpty()) throw IllegalArgumentException(MESSAGE_INPUT_EMPTY)
}

private const val MESSAGE_FOR_GUIDE_CALCULATE = "덧셈할 문자열을 입력해 주세요."
private const val MESSAGE_INPUT_EMPTY = "빈 값을 입력하였습니다."
