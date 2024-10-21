package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    print("덧셈할 문자열을 입력해 주세요: ")
    val input: String = Console.readLine()

    fun defaultSeparator(input: String): Int {
        val numbers = input.split(",", ":").map { it.toInt() }
        return numbers.sum()
    }

    val result: Int = defaultSeparator(input)
    println("결과: $result")
}

