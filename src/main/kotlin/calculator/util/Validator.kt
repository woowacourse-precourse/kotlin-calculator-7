package calculator.util

object Validator {
    private const val DELIMITER_MESSAGE = "잘못된 구분자 또는 기호가 포함되어 있습니다."
    private const val CUSTOM_DELIMITER_FORMAT_MESSAGE = "커스텀 구분자가 잘못된 형식으로 입력되었습니다."
    private const val NEGATIVE_NUMBER_MESSAGE = "입력에 음수가 포함되어 있습니다."

    fun validateInput(input: String) {
        if (input.startsWith("//")) {
            validateCustomDelimiterFormat(input)
            val customDelimiter = extractCustomDelimiter(input)
            validateCombineDelimiters(input, customDelimiter)
            return
        }
        validateDefaultDelimiter(input)
    }

    private fun validateDefaultDelimiter(input: String) {
        val invalidChars = input.filter {
            it !in "0123456789.,:" && !it.isWhitespace()
        }
        if (invalidChars.isNotEmpty()) {
            throw IllegalArgumentException(DELIMITER_MESSAGE)
        }
    }

    private fun validateCustomDelimiterFormat(input: String) {
        val customDelimiterPattern = Regex("^//([^\\d\\n])\\\\n.*")
        if (!customDelimiterPattern.matches(input)) {
            throw IllegalArgumentException(CUSTOM_DELIMITER_FORMAT_MESSAGE)
        }
    }

    private fun validateCombineDelimiters(input: String, customDelimiter: String) {
        val combinePattern = Regex("^[0-9${customDelimiter},:]+$")
        if (!combinePattern.matches(input.substringAfter("\\n"))) {
            throw IllegalArgumentException(DELIMITER_MESSAGE)
        }
    }

    fun validateNegativeNumbers(numbers: List<Int>) {
        val negatives = numbers.filter { it < 0 }
        if (negatives.isNotEmpty()) {
            throw IllegalArgumentException(NEGATIVE_NUMBER_MESSAGE)
        }
    }

    private fun extractCustomDelimiter(input: String): String {
        val delimiterIndex = input.indexOf("\\n")
        return input.substring(2, delimiterIndex)
    }
}
