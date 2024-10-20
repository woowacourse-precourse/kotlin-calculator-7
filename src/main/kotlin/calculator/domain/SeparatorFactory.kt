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


    companion object {
        private const val CUSTOM_SEPARATOR_PATTERN_VALUE = "^//(.)\\\\n.*"
    }
}
