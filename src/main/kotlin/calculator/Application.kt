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
        val delimiter = input.substringAfter("//").substringBefore("\n")
        val values = input.substringAfter("\n")
        val numbers = values.split(delimiter).map { it.toInt() }
        return numbers.sum()
    }

    val result: Int = customSeparator(input)
    println("결과: $result")
}

