package calculator.domain

class Calculator {

    fun sum(inputValue: String): Int {
        val separator = SeparatorFactory(inputValue).generateSeparator()
        val operand = Operand(inputValue, separator).getOperand()
        return operand.sum()
    }
}
