package calculator.domain

class Calculator(
    private var numbers: String
) {
    private val delimiters = mutableSetOf(BASIC_DELIMITER_COMMA, BASIC_DELIMITER_COLON)

    init {
        parseCustomDelimiter(numbers)
    }

    private fun parseCustomDelimiter(input: String) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            val customDelimiterStartIndex = CUSTOM_DELIMITER_PREFIX.length
            val customDelimiterEndIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX)

            if (customDelimiterEndIndex != -1) {
                val customDelimiter = input.substring(customDelimiterStartIndex, customDelimiterEndIndex)
                delimiters.add(customDelimiter)
                numbers = input.substring(customDelimiterEndIndex + CUSTOM_DELIMITER_SUFFIX.length)
            }
        }
    }

    companion object {
        private const val BASIC_DELIMITER_COMMA = ","
        private const val BASIC_DELIMITER_COLON = ":"
        private const val CUSTOM_DELIMITER_PREFIX = "//"
        private const val CUSTOM_DELIMITER_SUFFIX = "\\n"
    }
}