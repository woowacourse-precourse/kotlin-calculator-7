package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    try {
        val input = Console.readLine()
        val delimiterParser = DelimiterParser(input)
        val operands = delimiterParser.getOperands()
        val calculator = Calculator(operands)
        val result = calculator.calculate()
        println("결과 : $result")
    }
    catch (e: java.util.NoSuchElementException) {
        println("결과 : 0")
    }
    catch (e: IllegalArgumentException) {
        throw e
    }
}
