package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    print("덧셈할 문자열을 입력해 주세요: ")
    val input: String = Console.readLine()

    fun defaultSeparator(input: String): List<String> {
        return input.split(",", ":")
    }

    fun customSeparator(input: String): List<String> {
        val delimiter = input.substring(2, 3)
        val values = input.substring(5)
        return values.split(delimiter)
    }

    fun validateAndSum(values: List<String>): Int {
        val numbers = try {
            values.map { it.toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("잘못된 입력 형식입니다. (${e.message})")
        }
        if (numbers.any { it < 0 }) {
            throw IllegalArgumentException("음수 값이 포함되어 있습니다: $numbers")
        }
        return numbers.sum()
    }

    try {
        val values = when {
            input.isBlank() -> listOf("0")
            input.startsWith("//") -> customSeparator(input)
            else -> defaultSeparator(input)
        }
        val result = validateAndSum(values)
        println("결과 : $result")
    } catch (e: IllegalArgumentException) {
        throw IllegalArgumentException("잘못된 입력 형식입니다.")
    }
}
