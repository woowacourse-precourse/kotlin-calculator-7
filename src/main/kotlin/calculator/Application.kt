package calculator

import camp.nextstep.edu.missionutils.Console

private const val MESSAGE_INPUT_PROMPT = "덧셈할 문자열을 입력해 주세요."

fun main() {
    println(MESSAGE_INPUT_PROMPT)
    val input = Console.readLine()

    val calculator = Calculator(input)
    val result = calculator.calculate()

    println("결과 : $result")
}