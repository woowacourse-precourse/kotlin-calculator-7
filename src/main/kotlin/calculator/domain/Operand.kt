package calculator.domain

class Operand(
    private val inputValue: String,
    private val separator: Separator
) {
    private val operand = mutableListOf<Int>()
    private val generateCustomSeparatorPattern = Regex(GENERATE_CUSTOM_SEPARATOR_PATTERN)

    fun getOperand(): MutableList<Int> {
        processSeparators()
        return operand
    }

    private fun processSeparators() {
        if (separator.custom == null) {
            splitByDefaultSeparators()
        } else {
            splitByCustomSeparator()
        }
    }

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
        inputValue.replace(generateCustomSeparatorPattern, REPLACEMENT)

    private fun parseAndAddOperands(stringOperand: List<String>) {
        val operandList = parseStringToIntList(stringOperand)
        validateOperandsPositive(operandList)
        operand.addAll(operandList)
    }

    private fun parseStringToIntList(stringOperand: List<String>): List<Int> {
        return stringOperand.map {
            it.toIntOrNull() ?: throw IllegalArgumentException(ERROR_INVALID_NUMBER)
        }
    }

    private fun validateOperandsPositive(operandList: List<Int>) {
        operandList.forEach { operand ->
            if (operand <= ZERO) throw IllegalArgumentException(ERROR_NEGATIVE_NUMBER)
        }
    }

    companion object {
        private const val GENERATE_CUSTOM_SEPARATOR_PATTERN = "^//(.)\\\\n"
        private const val ZERO = 0
        private const val REPLACEMENT = ""
        private const val ERROR_NEGATIVE_NUMBER = "[ERROR] 입력 값은 양수여야 합니다."
        private const val ERROR_INVALID_NUMBER = "[ERROR] 숫자만 입력 가능합니다."
    }
}
