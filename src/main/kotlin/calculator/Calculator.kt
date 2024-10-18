package calculator

class Calculator(private val operands: List<String>) {
    fun calculate(): Int {
        return operands.sumOf{it.toInt()}
    }
}