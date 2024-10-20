package calculator.domain

class Operand(
    private val inputValue: String,
    private val separator: Separator
) {
    private val operand = mutableListOf<Int>()
}
