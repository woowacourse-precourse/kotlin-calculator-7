package calculator

import camp.nextstep.edu.missionutils.Console

private val divider = mutableListOf<String>(",", ":")
private var isCustomDividerUsed: Boolean = true

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine().split(CUSTOM_DIVIDER_PREFIX, CUSTOM_DIVIDER_SUFFIX)

    if (!checkInputTypeAndValidity(input)) throw IllegalArgumentException(INVALID_INPUT_MESSAGE)

    val numbers = input.splitByDivider()
    val sum = numbers.getSum()

    println("결과 : $sum")
}

private fun checkInputTypeAndValidity(input: List<String>): Boolean {
    return when {
        input.size >= CUSTOM_DIVIDER_EXCEEDING_SIZE -> false

        input.size == CUSTOM_DIVIDER_NONE_SIZE -> {
            isCustomDividerUsed = false
            true
        }

        input.first().isNotBlank() -> false

        else -> {
            divider.addLast(input[CUSTOM_DIVIDER_INDEX])
            true
        }
    }
}

private fun List<String>.splitByDivider(): List<Double> {
    if (this == listOf("")) return emptyList()

    val regex = divider.joinToString("|") { Regex.escape(it) }.toRegex()
    val expression = when (isCustomDividerUsed) {
        true -> this[NUMBERS_WITH_CUSTOM_DIVIDER_INDEX]
        false -> this[NUMBERS_WITHOUT_CUSTOM_DIVIDER_INDEX]
    }

    val splitResult = expression.split(regex)
    return splitResult.map {
        try {
            it.toDouble()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(INVALID_INPUT_MESSAGE)
        }
    }
}

private fun List<Double>.getSum(): Number {
    var sum = 0.0

    this.forEach { number ->
        sum += number
    }

    return if (sum % 1 == 0.0) sum.toLong() else sum
}

private const val INVALID_INPUT_MESSAGE = "유효하지 않은 입력입니다."

private const val CUSTOM_DIVIDER_PREFIX = "//"
private const val CUSTOM_DIVIDER_SUFFIX = "\\n"

private const val CUSTOM_DIVIDER_EXCEEDING_SIZE = 4
private const val CUSTOM_DIVIDER_NONE_SIZE = 1

private const val CUSTOM_DIVIDER_INDEX = 1

private const val NUMBERS_WITH_CUSTOM_DIVIDER_INDEX = 2
private const val NUMBERS_WITHOUT_CUSTOM_DIVIDER_INDEX = 0
