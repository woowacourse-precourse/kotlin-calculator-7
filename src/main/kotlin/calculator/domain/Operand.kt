package calculator.domain

class Operand(
    private val inputValue: String,
    private val separator: Separator
) {
    private val operand = mutableListOf<Int>()
    private val generateCustomSeparatorPattern = Regex(GENERATE_CUSTOM_SEPARATOR_PATTERN)

    private fun splitByDefaultSeparators() {
        val stringOperand = inputValue.split(separator.colon, separator.comma)
        parseAndAddOperands(stringOperand)
    }

    private fun splitByCustomSeparator() {
        val newValue = removeCustomSeparatorPattern()
        val stringOperand = newValue.split(separator.colon, separator.comma, separator.custom!!)
        parseAndAddOperands(stringOperand)
    }

    private fun removeCustomSeparatorPattern() =
        inputValue.replace(generateCustomSeparatorPattern, "")
    companion object {
        private const val GENERATE_CUSTOM_SEPARATOR_PATTERN = "^//(.)\\\\n"
    }
}
