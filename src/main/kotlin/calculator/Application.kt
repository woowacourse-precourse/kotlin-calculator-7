package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println(MESSAGE_INPUT_NUMBER)

    val input = Console.readLine()

    if (isEmptyOrSingleNumber(input)) return
    val isCustomDelimiter = input.substring(0, 2) == CUSTOM_DELIMITER_PREFIX

    val delimiterSet = getDelimiterSet(isCustomDelimiter, input)
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
private const val CUSTOM_DELIMITER_PREFIX = "//"
private const val CUSTOM_DELIMITER_SUFFIX = "\\n"
private const val BASIC_DELIMITER_COMMA = ","
private const val BASIC_DELIMITER_COLON = ":"
private const val MESSAGE_RESULT_NUMBER = "결과 : %s"
