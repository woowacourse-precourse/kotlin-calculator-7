package calculator

import camp.nextstep.edu.missionutils.Console

class StringAddingCalculator {
    fun runCalculator() {
            println("덧셈할 문자열을 입력해 주세요.")
            val inputText = Console.readLine()
            val sum = calculateSum(inputText)
            println("결과 : $sum")
    }

    private fun calculateSum(inputText: String): Int {
        if (inputText.isBlank()) {
            throw IllegalArgumentException(EMPTY_STRING_ERROR)
        }

        val (numbers, delimiters) = divideInputText(inputText)
        println(numbers)

        val numberList = divideNumbers(numbers, delimiters)
        return sumValidNumbers(numberList)
    }

    private fun divideInputText(inputText: String): Pair<String, List<String>> {
        return if (inputText.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            val customDelimiterEndIndex = inputText.indexOf(CUSTOM_DELIMITER_END)
            if (customDelimiterEndIndex == -1) {
                throw IllegalArgumentException(INVALID_DELIMITER_FORMAT_ERROR)
            }

            val customDelimiter = inputText.substring(2, customDelimiterEndIndex)
            val numbers = inputText.substring(customDelimiterEndIndex + 2)

            Pair(numbers, listOf(customDelimiter))
        } else {
            Pair(inputText, DEFAULT_DELIMITERS)
        }
    }

    private fun divideNumbers(numbers: String, delimiters: List<String>): List<String> {
        return numbers.split(*delimiters.toTypedArray())
            .filter { it.isNotBlank() }
            .map { it.trim() }
    }

    private fun sumValidNumbers(numberList: List<String>): Int {
        return numberList.sumOf { parseAndValidateNumber(it) }
    }

    private fun parseAndValidateNumber(number: String): Int {
        return number.toIntOrNull()?.takeIf { it >= 0 }
            ?: throw IllegalArgumentException("$NEGATIVE_NUMBER_ERROR $number")
    }

    companion object {
        private const val EMPTY_STRING_ERROR = "빈 문자열은 입력할 수 없습니다."
        private const val INVALID_DELIMITER_FORMAT_ERROR = "구분자 형식이 올바르지 않습니다."
        private const val NEGATIVE_NUMBER_ERROR = "음수는 입력할 수 없습니다: "
        private val DEFAULT_DELIMITERS = listOf(",", ":")
        private const val CUSTOM_DELIMITER_PREFIX = "//"
        private const val CUSTOM_DELIMITER_END = "\\n"
    }
}