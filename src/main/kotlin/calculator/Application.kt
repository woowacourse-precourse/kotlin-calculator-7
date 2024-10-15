package calculator

import camp.nextstep.edu.missionutils.Console

private val CUSTOM_DELIMITER_BEFORE_FLAG = "//"
private val CUSTOM_DELIMITER_AFTER_FLAG = "\\n"
private val CUSTOM_DELIMITER_START_INDEX = 2
private var delimiter = arrayOf(",",":")

fun main() {
    val input = Console.readLine()

    if(hasCustomDelimiters(input)){
        delimiter = setCustomDelimiter(input)
    }

    val delimitedInput = input.split(*delimiter).toList()
    try {
        val numbers = delimitedInput.map { it.toIntOrNull() ?: throw IllegalArgumentException() }.toTypedArray()
        println(numbers.sum())
    }catch (e : IllegalArgumentException){
        println("입력에 문제가 생겼습니다.")
        return
    }
}

private fun hasCustomDelimiters(input: String) =
    input.startsWith(CUSTOM_DELIMITER_BEFORE_FLAG) &&
            input.indexOf(CUSTOM_DELIMITER_AFTER_FLAG) != -1

private fun setCustomDelimiter(input: String): Array<String> {
    val customDelimiterEndIndex = input.indexOf(CUSTOM_DELIMITER_AFTER_FLAG)
    val delimiters = input.substring(CUSTOM_DELIMITER_START_INDEX, customDelimiterEndIndex)
    return delimiters.map { it.toString() }.toTypedArray()
}

