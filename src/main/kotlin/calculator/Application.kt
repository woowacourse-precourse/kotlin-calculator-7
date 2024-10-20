package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println(MESSAGE_INPUT_NUMBER)

    val input = Console.readLine()

    if (isEmptyOrSingleNumber(input)) return
    val isCustomDelimiter = input.substring(0, 2) == CUSTOM_DELIMITER_PREFIX

    val delimiterSet = getDelimiterSet(isCustomDelimiter, input)
    val regexPattern = getRegexPattern(delimiterSet)

    val numbers = getNumbers(input, regexPattern)

    val result = numbers.sum()

    println(MESSAGE_RESULT_NUMBER.replace("%s", result.toString()))
}

private fun isEmptyOrSingleNumber(input: String): Boolean {
    if (input.isEmpty()) {
        println(MESSAGE_RESULT_NUMBER.replace("%s", "0"))
        return true
    }

    val number = input.toLongOrNull()
    if (number != null) {
        println(MESSAGE_RESULT_NUMBER.replace("%s", number.toString()))
        return true
    }
    return false
}

private fun getNumbers(input: String, regexPattern: Regex): List<Long> {
    return input
        .substringAfter(CUSTOM_DELIMITER_SUFFIX)
        .split(regexPattern)
        .map { validateNumber(it) }
}

private fun getRegexPattern(delimiterSet: Set<String>): Regex {
    return delimiterSet.joinToString(separator = REGEX_SEPARATOR) {
        Regex.escape(it)
    }.toRegex()
}

private fun getDelimiterSet(isCustomDelimiter: Boolean, input: String): Set<String> {
    return if (isCustomDelimiter) {
        val customDelimiter = input
            .substringAfter(CUSTOM_DELIMITER_PREFIX)
            .substringBefore(CUSTOM_DELIMITER_SUFFIX)
        setOf(customDelimiter, BASIC_DELIMITER_COMMA, BASIC_DELIMITER_COLON)
    } else {
        setOf(BASIC_DELIMITER_COMMA, BASIC_DELIMITER_COLON)
    }
}

private fun validateNumber(value: String): Long {
    val number = value.toLongOrNull() ?: throw IllegalArgumentException(MESSAGE_INVALID_NUMBER.replace("%s", value))
    if (number < 0) throw IllegalArgumentException(MESSAGE_NEGATIVE_NUMBER.replace("%s", number.toString()))
    return number
}

private const val CUSTOM_DELIMITER_PREFIX = "//"
private const val CUSTOM_DELIMITER_SUFFIX = "\\n"
private const val BASIC_DELIMITER_COMMA = ","
private const val BASIC_DELIMITER_COLON = ":"
private const val REGEX_SEPARATOR = "|"
private const val MESSAGE_INPUT_NUMBER = "덧셈할 문자열을 입력해 주세요."
private const val MESSAGE_INVALID_NUMBER = "숫자가 아닌 값이 포함되어 있습니다: '%s'"
private const val MESSAGE_NEGATIVE_NUMBER = "음수는 허용되지 않습니다: '%s'"
private const val MESSAGE_RESULT_NUMBER = "결과 : %s"