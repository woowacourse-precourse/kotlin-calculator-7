package calculator.domain

class Calculator(
    private var expression: String
) {
    private val delimiters = mutableSetOf(BASIC_DELIMITER_COMMA, BASIC_DELIMITER_COLON)
    private val numbers = mutableListOf<Int>()

    init {
        processExpression()
    }

    fun add(): Int = numbers.sum()

    private fun processExpression() {
        if (hasCustomDelimiter()) {
            parseCustomDelimiter()
        }
        parseNumbers()
    }

    private fun hasCustomDelimiter(): Boolean =
        expression.startsWith(CUSTOM_DELIMITER_PREFIX) && expression.indexOf(CUSTOM_DELIMITER_SUFFIX) != -1

    private fun parseCustomDelimiter() {
        val customDelimiter = findCustomDelimiter()
        delimiters.add(customDelimiter)
        removeCustomDelimiterFromExpression()
    }

    private fun findCustomDelimiter(): Char {
        val customDelimiterStartIndex = CUSTOM_DELIMITER_PREFIX.length
        val customDelimiterEndIndex = expression.indexOf(CUSTOM_DELIMITER_SUFFIX)

        val customDelimiter =
            expression.substring(customDelimiterStartIndex, customDelimiterEndIndex)
        validateCustomDelimiter(customDelimiter)
        return customDelimiter[0]
    }

    private fun removeCustomDelimiterFromExpression() {
        val customDelimiterEndIndex = expression.indexOf(CUSTOM_DELIMITER_SUFFIX)
        expression = expression.substring(customDelimiterEndIndex + CUSTOM_DELIMITER_SUFFIX.length)
    }

    private fun parseNumbers() {
        if (expression.isBlank()) return

        val splitNumbers = splitExpressionByDelimiters()
        for (number in splitNumbers) {
            val parsedNumber = parseNumber(number)
            validatePositiveNumber(parsedNumber)
            numbers.add(parsedNumber)
        }
    }

    private fun splitExpressionByDelimiters(): List<String> {
        return expression.split(*delimiters.toCharArray())
    }

    private fun parseNumber(number: String): Int =
        number.toIntOrNull() ?: throw IllegalArgumentException(ERROR_INVALID_EXPRESSION)

    private fun validateCustomDelimiter(delimiter: String) {
        if (delimiter.length != 1) throw IllegalArgumentException(ERROR_INVALID_CUSTOM_DELIMITER)
    }

    private fun validatePositiveNumber(number: Int) {
        if (number <= 0) throw IllegalArgumentException(ERROR_NUMBER_NOT_POSITIVE)
    }

    companion object {
        private const val BASIC_DELIMITER_COMMA = ','
        private const val BASIC_DELIMITER_COLON = ':'
        private const val CUSTOM_DELIMITER_PREFIX = "//"
        private const val CUSTOM_DELIMITER_SUFFIX = "\\n"

        private const val ERROR_INVALID_EXPRESSION = "[ERROR] 구분자와 양수로 구성된 문자열을 입력해야 합니다."
        private const val ERROR_INVALID_CUSTOM_DELIMITER = "[ERROR] 커스텀 구분자 형식이 올바르지 않습니다."
        private const val ERROR_NUMBER_NOT_POSITIVE = "[ERROR] 숫자는 0 이상이어야 합니다."
    }
}