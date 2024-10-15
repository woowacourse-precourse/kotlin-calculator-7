package calculator

import camp.nextstep.edu.missionutils.Console

private val CUSTOM_DELIMITER_BEFORE_FLAG = "//"
private val CUSTOM_DELIMITER_AFTER_FLAG = "\\n"
private val CUSTOM_DELIMITER_START_INDEX = 2
private var delimiter = ",:"

fun main() {
}

private fun hasCustomDelimiters(input: String) =
    input.startsWith(CUSTOM_DELIMITER_BEFORE_FLAG) &&
            input.indexOf(CUSTOM_DELIMITER_AFTER_FLAG) != -1

private fun setCustomDelimiter(input: String): String {
    val customDelimiterEndIndex = input.indexOf(CUSTOM_DELIMITER_AFTER_FLAG)
    return input.substring(CUSTOM_DELIMITER_START_INDEX, customDelimiterEndIndex)
}
