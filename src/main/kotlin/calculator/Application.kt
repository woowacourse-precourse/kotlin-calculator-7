package calculator

import camp.nextstep.edu.missionutils.Console

private const val CUSTOM_DELIMITER_PREFIX = "//"
private const val CUSTOM_DELIMITER_SUFFIX = "\\n"

private const val CUSTOM_DELIMITER_SUFFIX_NOT_FOUND = -1
private const val CUSTOM_DELIMITER_PREFIX_LENGTH = 2

private const val ERROR_INVALID_INPUT = "입력이 유효하지 않습니다."

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()

    val (isValid, delimiter, numbersPart) = checkInputValidity(input)

    if (!isValid) {
        throw IllegalArgumentException(ERROR_INVALID_INPUT)
    }
}

private fun checkInputValidity(input: String): Triple<Boolean, String?, String> {
    if (input.isEmpty()) return Triple(false, null, "")

    val (delimiter, numbers) = if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
        val newlineIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX)

        if (newlineIndex != CUSTOM_DELIMITER_SUFFIX_NOT_FOUND) {
            input.substring(CUSTOM_DELIMITER_PREFIX_LENGTH, newlineIndex) to input.substring(newlineIndex + CUSTOM_DELIMITER_PREFIX_LENGTH)
        } else return Triple(false, null, "")

    } else {
        null to input
    }

    val isValid =
        numbers.split(delimiter ?: ",", ":").all { it.isEmpty() || isValidNumber(it.trim()) }

    return Triple(isValid, delimiter, numbers)
}

private fun isValidNumber(value: String): Boolean {
    val number = value.toDoubleOrNull()

    return number != null && number > 0 && number <= Int.MAX_VALUE
}