package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    print("덧셈할 문자열을 입력해 주세요: ")
    val input: String = Console.readLine()

    fun defaultSeparator(input: String): Int {
        val numbers = input.split(",", ":").map { it.toInt() }
        return numbers.sum()
    }

    fun customSeparator(input: String): Int {
        val delimiter = input.substring(2, 3)
        val values = input.substring(5)
        val numbers = values.split(delimiter).map { it.toInt() }
        return numbers.sum()
    }

    val result = when {
        input.isBlank() -> 0
        input.startsWith("//") -> customSeparator(input)
        else -> defaultSeparator(input)
    }

    println("결과: $result")
}

