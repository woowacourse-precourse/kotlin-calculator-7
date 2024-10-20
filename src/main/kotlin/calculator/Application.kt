package calculator

import camp.nextstep.edu.missionutils.Console

private const val INPUT_SUM_STRING_MESSAGE = "덧셈할 문자열을 입력해 주세요."
private const val CUSTOM_DELIMITER_PREFIX = "//"
private const val NEW_LINE = """\n"""
private const val NOT_FOUND_CUSTOM_DELIMITER_MESSAGE = "커스텀 구분자를 찾을 수 없습니다."
private const val DEFAULT_DELIMITER_PATTERN = "[,:]"
private const val INVALID_NUMBER_FORMAT_MESSAGE = "잘못된 숫자 형식입니다."
private const val MULTIPLE_CONSECUTIVE_DELIMITERS_MESSAGE = "여러 개의 구분자가 연속으로 나타날 수 없습니다."
private const val TRAILING_DELIMITER_MESSAGE = "숫자 뒤에 구분자만 있을 수 없습니다."
private const val NEGATIVE_NUMBER_NOT_ALLOWED_MESSAGE = "음수는 허용되지 않습니다."
private const val PRINT_RESULT_MESSAGE = "결과 : %d"


fun main() {
    println(INPUT_SUM_STRING_MESSAGE)
    val input = Console.readLine().trim()

    if (input.isBlank()) {
        println(0)
        return
    }

    val result = add(input)
    println(String.format(PRINT_RESULT_MESSAGE, result))
}

private fun add(input: String): Int {
    val (delimiter, numberStr) = parseInput(input)
    val nums = splitNumbers(numberStr, delimiter)

    checkForNegativeNumbers(nums)
    return sum(nums)
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

private fun splitNumbers(numberStr: String, delimiter: Regex): List<String> {
    val nums = numberStr.split(delimiter).map { it.trim() }.filter { it.isNotEmpty() }

    if (nums.any { it.toIntOrNull() == null }) {
        throw IllegalArgumentException(INVALID_NUMBER_FORMAT_MESSAGE)
    }

    if (numberStr.contains(Regex("$delimiter{2,}"))) {
        throw IllegalArgumentException(MULTIPLE_CONSECUTIVE_DELIMITERS_MESSAGE)
    }

    if (numberStr.matches(Regex(".*$delimiter$"))) {
        throw IllegalArgumentException(TRAILING_DELIMITER_MESSAGE)
    }

    return nums
}

private fun checkForNegativeNumbers(nums: List<String>) {
    nums.forEach {
        val number = it.toInt()
        if (number < 0) {
            throw IllegalArgumentException(NEGATIVE_NUMBER_NOT_ALLOWED_MESSAGE)
        }
    }
}

private fun sum(nums: List<String>): Int {
    return nums.sumOf { it.toInt() }
}
