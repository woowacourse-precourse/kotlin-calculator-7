package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input: String = Console.readLine()

    val numbers: List<Int> = runCatching {
        val split: List<String> = input.split(",", ":").map { it.ifEmpty { "0" } }
        split.map { it.toInt() }
    }.getOrElse { throw IllegalArgumentException() }

    if (numbers.any { it < 0 }) {
        throw IllegalArgumentException()
    }

    println("결과 : ${numbers.sum()}")
}
