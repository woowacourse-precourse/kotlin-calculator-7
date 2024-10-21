package calculator.domain

class Calculator(
    private var expression: String
) {
    private val delimiters = mutableSetOf(BASIC_DELIMITER_COMMA, BASIC_DELIMITER_COLON)
    private val numbers = mutableListOf<Int>()

    init {
        parseCustomDelimiter()
        parseNumbers()
    }

    fun add(): Int {
        return numbers.sum()
    }

    private fun parseCustomDelimiter() {
        if (expression.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            val customDelimiterStartIndex = CUSTOM_DELIMITER_PREFIX.length
            val customDelimiterEndIndex = expression.indexOf(CUSTOM_DELIMITER_SUFFIX)

            if (customDelimiterEndIndex != -1) {
                val customDelimiter = expression.substring(customDelimiterStartIndex, customDelimiterEndIndex)
                delimiters.add(customDelimiter)
                expression = expression.substring(customDelimiterEndIndex + CUSTOM_DELIMITER_SUFFIX.length)
            }
        }
    }

    private fun parseNumbers() {
        if (expression.isBlank()) {
            return
        }

        val parsedExpression: List<String> = expression.split(*delimiters.toTypedArray())
        for (number in parsedExpression) {
            val n = number.toIntOrNull()
            validateNumber(n)
            validatePositiveNumber(n!!)
            numbers.add(n)
        }
    }

    private fun validateNumber(number: Int?) {
        if (number == null) throw IllegalArgumentException()
    }

    private fun validatePositiveNumber(number: Int) {
        if (number <= 0) throw IllegalArgumentException(ERROR_NUMBER_NOT_POSITIVE)
    }

    companion object {
        private const val BASIC_DELIMITER_COMMA = ","
        private const val BASIC_DELIMITER_COLON = ":"
        private const val CUSTOM_DELIMITER_PREFIX = "//"
        private const val CUSTOM_DELIMITER_SUFFIX = "\\n"

        private const val ERROR_NUMBER_NOT_POSITIVE = "[ERROR] 숫자는 0 이상이어야 합니다."
    }
}