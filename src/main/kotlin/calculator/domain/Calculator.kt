package calculator.domain

class Calculator(
    private var input: String
) {
    private val delimiters = mutableSetOf(BASIC_DELIMITER_COMMA, BASIC_DELIMITER_COLON)
    private var stringNumbers: String = input
    private val numbers = mutableListOf<Int>()

    init {
        parseCustomDelimiter()
        parseNumbers()
    }

    private fun parseCustomDelimiter() {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            val customDelimiterStartIndex = CUSTOM_DELIMITER_PREFIX.length
            val customDelimiterEndIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX)

            if (customDelimiterEndIndex != -1) {
                val customDelimiter = input.substring(customDelimiterStartIndex, customDelimiterEndIndex)
                delimiters.add(customDelimiter)
                stringNumbers = input.substring(customDelimiterEndIndex + CUSTOM_DELIMITER_SUFFIX.length)
            }
        }
    }

    private fun parseNumbers() {
        numbers.addAll(stringNumbers.split(*delimiters.toTypedArray()).map { it.toInt() })
        println(numbers)
    }

    companion object {
        private const val BASIC_DELIMITER_COMMA = ","
        private const val BASIC_DELIMITER_COLON = ":"
        private const val CUSTOM_DELIMITER_PREFIX = "//"
        private const val CUSTOM_DELIMITER_SUFFIX = "\\n"
    }
}