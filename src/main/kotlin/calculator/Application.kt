package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input: String = Console.readLine()
    val hasCustomDelimiter: Boolean = input.length >= 5
            && input.slice(0..1) == "//"
            && input.slice(3..4) == "\\n"

    val sum: Int = if (hasCustomDelimiter) {
        val customDelimiter = input[2].toString()
        if (customDelimiter.toIntOrNull() != null) {
            throw IllegalArgumentException()
        }
        val numbers: List<Int> = runCatching {
            val newInput: String = input.substring(5)
            val split: List<String> = newInput.split(",", ":", customDelimiter).map { it.ifEmpty { "0" } }
            split.map { it.toInt() }
        }.getOrElse { throw IllegalArgumentException() }

        if (numbers.any { it < 0 }) {
            throw IllegalArgumentException()
        }

        numbers.sum()
    } else {
        val numbers: List<Int> = runCatching {
            val split: List<String> = input.split(",", ":").map { it.ifEmpty { "0" } }
            split.map { it.toInt() }
        }.getOrElse { throw IllegalArgumentException() }

        if (numbers.any { it < 0 }) {
            throw IllegalArgumentException()
        }

        numbers.sum()
    }

    println("결과 : $sum")
}
