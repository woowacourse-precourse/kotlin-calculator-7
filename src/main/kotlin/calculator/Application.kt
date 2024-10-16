package calculator

import camp.nextstep.edu.missionutils.Console

private val divider = mutableListOf<String>(",", ":")
private var isCustomDividerUsed: Boolean = true

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine().split(CUSTOM_DIVIDER_PREFIX, CUSTOM_DIVIDER_SUFFIX)

    if (!checkInputValid(input)) throw IllegalArgumentException(INVALID_INPUT_MESSAGE)

    val numbers = splitByDivider(input)
}

private fun checkInputValid(input: List<String>): Boolean {
    return when {
        input.size > CUSTOM_DIVIDER_EXCEEDING_COUNT -> false

        input.size == CUSTOM_DIVIDER_NONE_COUNT -> {
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

private fun splitByDivider(input: List<String>): List<Int> {
    if (input == listOf("")) return emptyList()

    val regex = divider.joinToString("|") { Regex.escape(it) }.toRegex()
    val expression = when (isCustomDividerUsed) {
        true -> input[NUMBERS_INDEX_WITH_CUSTOM_DIVIDER]
        false -> input[NUMBERS_INDEX_WITHOUT_CUSTOM_DIVIDER]
    }

    val splitResult = expression.split(regex)
    return splitResult.map {
        try {
            it.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(INVALID_INPUT_MESSAGE)
        }
    }
}

private const val INVALID_INPUT_MESSAGE = "유효하지 않은 입력입니다."

private const val CUSTOM_DIVIDER_PREFIX = "//"
private const val CUSTOM_DIVIDER_SUFFIX = "\\n"

private const val CUSTOM_DIVIDER_EXCEEDING_COUNT = 3
private const val CUSTOM_DIVIDER_NONE_COUNT = 1

private const val CUSTOM_DIVIDER_INDEX = 1

private const val NUMBERS_INDEX_WITH_CUSTOM_DIVIDER = 2
private const val NUMBERS_INDEX_WITHOUT_CUSTOM_DIVIDER = 0
