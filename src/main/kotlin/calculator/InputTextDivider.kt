package calculator

class InputTextDivider {
    fun divideInputText(inputText: String): Pair<String, List<String>> {
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

    fun divideNumbers(numbers: String, delimiters: List<String>): List<String> {
        return numbers.split(*delimiters.toTypedArray())
            .filter { it.isNotBlank() }
            .map { it.trim() }
    }

    companion object {
        private const val INVALID_DELIMITER_FORMAT_ERROR = "구분자 형식이 올바르지 않습니다."
        private val DEFAULT_DELIMITERS = listOf(",", ":")
        private const val CUSTOM_DELIMITER_PREFIX = "//"
        private const val CUSTOM_DELIMITER_END = "\\n"
    }
}