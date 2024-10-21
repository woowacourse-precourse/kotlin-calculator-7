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

        val stringNumbers: List<String>  = expression.split(*delimiters.toTypedArray())
        for (number in stringNumbers) {
            val n = number.toInt()
            numbers.add(n)
        }
    }

    companion object {
        private const val BASIC_DELIMITER_COMMA = ","
        private const val BASIC_DELIMITER_COLON = ":"
        private const val CUSTOM_DELIMITER_PREFIX = "//"
        private const val CUSTOM_DELIMITER_SUFFIX = "\\n"
    }
}