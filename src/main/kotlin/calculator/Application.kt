package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    val calculator = Calculator()

    println("덧셈할 문자열을 입력해 주세요.")
    val inputString = Console.readLine()

    calculator.calculateString(inputString)
}
