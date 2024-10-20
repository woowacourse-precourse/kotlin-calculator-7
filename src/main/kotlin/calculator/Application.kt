package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println(MESSAGE_INPUT_NUMBER)

    val input = Console.readLine()

    if (isEmptyOrSingleNumber(input)) return
    val isCustomDelimiter = input.substring(0, 2) == CUSTOM_DELIMITER_PREFIX
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
private const val CUSTOM_DELIMITER_PREFIX = "//"
private const val CUSTOM_DELIMITER_SUFFIX = "\\n"
private const val MESSAGE_RESULT_NUMBER = "결과 : %s"
