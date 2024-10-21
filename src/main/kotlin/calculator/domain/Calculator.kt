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

    fun add(): Int = numbers.sum()

    private fun parseCustomDelimiter() {
        if (expression.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            val customDelimiterStartIndex = CUSTOM_DELIMITER_PREFIX.length
            val customDelimiterEndIndex = expression.indexOf(CUSTOM_DELIMITER_SUFFIX)

            if (customDelimiterEndIndex != -1) {
                val customDelimiter = expression.substring(customDelimiterStartIndex, customDelimiterEndIndex)
                validateCustomDelimiter(customDelimiter)
                delimiters.add(customDelimiter[0])
                expression = expression.substring(customDelimiterEndIndex + CUSTOM_DELIMITER_SUFFIX.length)
            }
        }
    }

    private fun parseNumbers() {
        if (expression.isBlank()) {
            return
        }

        val parsedExpression: List<String> = expression.split(*delimiters.toCharArray())
        for (number in parsedExpression) {
            val n = number.toIntOrNull()
            validateNumber(n)
            validatePositiveNumber(n!!)
            numbers.add(n)
        }
    }

    private fun validateCustomDelimiter(delimiter: String) {
        if (delimiter.length != 1) throw IllegalArgumentException(ERROR_INVALID_CUSTOM_DELIMITER)
    }

    private fun validateNumber(number: Int?) {
        if (number == null) throw IllegalArgumentException(ERROR_INVALID_NUMBER)
    }

    private fun validatePositiveNumber(number: Int) {
        if (number <= 0) throw IllegalArgumentException(ERROR_NUMBER_NOT_POSITIVE)
    }

    companion object {
        private const val BASIC_DELIMITER_COMMA = ','
        private const val BASIC_DELIMITER_COLON = ':'
        private const val CUSTOM_DELIMITER_PREFIX = "//"
        private const val CUSTOM_DELIMITER_SUFFIX = "\\n"

        private const val ERROR_INVALID_NUMBER = "[ERROR] 구분자 이외의 문자는 입력할 수 없습니다."
        private const val ERROR_INVALID_CUSTOM_DELIMITER = "[ERROR] 커스텀 구분자는 한 문자여야 합니다."
        private const val ERROR_NUMBER_NOT_POSITIVE = "[ERROR] 숫자는 0 이상이어야 합니다."
    }
}