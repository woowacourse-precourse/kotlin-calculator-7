package calculator

import camp.nextstep.edu.missionutils.Console

private const val INPUT_SUM_STRING_MESSAGE = "덧셈할 문자열을 입력해 주세요."
private const val CUSTOM_DELIMITER_PREFIX = "//"
private const val NEW_LINE = """\n"""
private const val NOT_FOUND_CUSTOM_DELIMITER_MESSAGE = "커스텀 구분자를 찾을 수 없습니다."
private const val DEFAULT_DELIMITER_PATTERN = "[,:]"

fun main() {
    println(INPUT_SUM_STRING_MESSAGE)
    val input = Console.readLine().trim()

    if (input.isBlank()) {
        println(0)
        return
    }
}

private fun parseInput(input: String): Pair<Regex, String> {
    return if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
        val delimiterEndPosition = input.indexOf(NEW_LINE)
        if (delimiterEndPosition == -1) {
            throw IllegalArgumentException(NOT_FOUND_CUSTOM_DELIMITER_MESSAGE)
        }

        val customDelimiterPattern = input.substring(2, delimiterEndPosition).trim()
        if (customDelimiterPattern.isEmpty()) {
            throw IllegalArgumentException(NOT_FOUND_CUSTOM_DELIMITER_MESSAGE)
        }

        val delimitedNumbers = input.substring(delimiterEndPosition + 2)
        Pair(Regex(Regex.escape(customDelimiterPattern)), delimitedNumbers)
    } else {
        Pair(Regex(DEFAULT_DELIMITER_PATTERN), input)
    }
}
