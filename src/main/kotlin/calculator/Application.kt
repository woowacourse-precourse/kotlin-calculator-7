package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()

    val calculator = StringCalculator()
    if (calculator.isValid(input)) {
        val result = calculator.calculate(input)
        println("결과 : $result")
    } else {
        println("잘못된 입력입니다.")
    }
}

class StringCalculator {
    fun calculate(input: String): Int {
        if (input.isEmpty()) return 0

        val numbers = input.split(",", ":")
        return numbers.map { it.toInt() }.sum()
    }

    fun isValid(input: String): Boolean {
        if (input.isEmpty()) return true

        val numbers = input.split(",", ":")
        return numbers.all { it.toIntOrNull() != null }
    }
}
