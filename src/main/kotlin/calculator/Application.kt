package calculator

import calculator.util.Constant
import calculator.util.Constant.WELCOME_MESSAGE
import calculator.util.Converter

fun main() {
    val calculator = Calculator()

    println(WELCOME_MESSAGE)
    val input = Input.readLine()
    val numbers = Converter.extractNumberByInput(input)
    System.out.format(Constant.RESULT_FORMAT, calculator.sum(numbers))
}