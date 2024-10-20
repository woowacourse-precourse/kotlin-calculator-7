package calculator.domain

class SeparatorFactory(
    private val inputValue: String
) {
    private var separator: Separator = Separator()
    private val customSeparatorPatternValue = Regex(CUSTOM_SEPARATOR_PATTERN_VALUE)

    private fun processCustomSeparatorPattern() {
        if (customSeparatorPatternValue.matches(inputValue)) {
            validateAndApplyCustomSeparator()
        }
    }

    private fun validateAndApplyCustomSeparator() {
        val customSeparator = inputValue[SEPARATOR_INDEX_NUMBER]
        validateCustomSeparator(customSeparator)
        applyCustomSeparator(customSeparator)
    }

    private fun validateCustomSeparator(customSeparator: Char) {
        if (customSeparator.isLetterOrDigit()) {
            throw IllegalArgumentException(ERROR_INVALID_CUSTOM_SEPARATOR)
        }
    }
    companion object {
        private const val CUSTOM_SEPARATOR_PATTERN_VALUE = "^//(.)\\\\n.*"
        private const val SEPARATOR_INDEX_NUMBER = 2
        private const val ERROR_INVALID_CUSTOM_SEPARATOR = "[ERROR] 커스텀 구분자는 특수문자여야 합니다."
    }
}
