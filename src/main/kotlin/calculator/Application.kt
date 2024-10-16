package calculator

import camp.nextstep.edu.missionutils.Console

class Calculator {
    private val INIT_MESSAGE = "덧셈할 문자열을 입력해 주세요."
    var input: String? = ""

    fun initCalculator() {
        println(INIT_MESSAGE)
        input = readLine()
        input = input?.replace(" ", "")
        println(input)
    }
}

fun main() {
    // TODO: 프로그램 구현
    val calculator = Calculator()
    calculator.initCalculator()
}
