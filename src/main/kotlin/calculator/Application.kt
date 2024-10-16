package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine().split(CUSTOM_DIVIDER_PREFIX, CUSTOM_DIVIDER_SUFFIX)

    if (!checkInputValid(input)) throw IllegalArgumentException(INVALID_INPUT_MESSAGE)
}

private fun checkInputValid(input: List<String>): Boolean {
    return when {
        input.size > CUSTOM_DIVIDER_EXCEEDING_COUNT -> false

        input.size == CUSTOM_DIVIDER_NONE_COUNT -> true

        input.first().isNotBlank() -> false

        else -> true
    }
}

private const val INVALID_INPUT_MESSAGE = "유효하지 않은 입력입니다."

private const val CUSTOM_DIVIDER_PREFIX = "//"
private const val CUSTOM_DIVIDER_SUFFIX = "\\n"

private const val CUSTOM_DIVIDER_EXCEEDING_COUNT = 3
private const val CUSTOM_DIVIDER_NONE_COUNT = 1
