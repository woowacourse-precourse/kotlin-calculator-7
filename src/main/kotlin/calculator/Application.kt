package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println(MESSAGE_INPUT_NUMBER)

    val input = Console.readLine()

    if (isEmptyOrSingleNumber(input)) return
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
private const val MESSAGE_RESULT_NUMBER = "결과 : %s"
