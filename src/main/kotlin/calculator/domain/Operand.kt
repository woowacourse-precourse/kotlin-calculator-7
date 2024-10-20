package calculator.domain

class Operand(
    private val inputValue: String,
    private val separator: Separator
) {
    private val operand = mutableListOf<Int>()

    private fun splitByDefaultSeparators() {
        val stringOperand = inputValue.split(separator.colon, separator.comma)
        parseAndAddOperands(stringOperand)
    }
}
