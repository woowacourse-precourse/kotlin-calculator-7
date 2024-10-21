package calculator

import camp.nextstep.edu.missionutils.Console

class Calculator() {
    fun execute() {
        try {
            val input = Console.readLine()
            val delimiterParser = DelimiterParser(input)
            val operands = delimiterParser.getOperands()
            val result = calculate(operands)
            println("결과 : $result")
        }
        catch (e: java.util.NoSuchElementException) {
            println("결과 : 0")
        }
        catch (e: IllegalArgumentException) {
            throw e
        }
    }

    private fun calculate(operands: List<String>): Int {
        return operands.sumOf{it.toInt()}
    }
}