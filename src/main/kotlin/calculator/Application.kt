package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println(INPUT_STRING)
    val input: String = Console.readLine()
    val hasCustomDelimiter: Boolean = input.length >= 5
            && input.slice(0..1) == CUSTOM_DELIMITER_REGEX_START
            && input.slice(3..4) == CUSTOM_DELIMITER_REGEX_END

    val sum: Int = if (hasCustomDelimiter) {
        val customDelimiter = input[2].toString()
        if (customDelimiter.toIntOrNull() != null) {
            throw IllegalArgumentException()
        }
        validateInputAndSum(input, DEFAULT_DELIMITER_COMMA, DEFAULT_DELIMITER_COLON, customDelimiter)
    } else {
        validateInputAndSum(input, DEFAULT_DELIMITER_COMMA, DEFAULT_DELIMITER_COLON)
    }

    println("$RESULT_STRING$sum")
}

private fun validateInputAndSum(input: String, vararg delimiters: String): Int {
    val numbers: List<Int> = runCatching {
        val newInput: String = if (delimiters.size > 2) input.substring(5) else input
        val split: List<String> = newInput.split(delimiters = delimiters).map { it.ifEmpty { ZERO_STRING } }
        split.map { it.toInt() }
    }.getOrElse { throw IllegalArgumentException() }

    if (numbers.any { it < 0 }) {
        throw IllegalArgumentException()
    }

    return numbers.sum()
}
