package calculator

import calculator.util.Constant
import calculator.util.Constant.WELCOME_MESSAGE
import calculator.util.Converter

fun main() {
    val calculator = Calculator()
    while (true) {
        println(WELCOME_MESSAGE)
        val input = Input.readLine()
        if (exitCalculator(input)) break
        try {
            val numbers = Converter.extractNumberByInput(input)
            System.out.format(Constant.RESULT_FORMAT, calculator.sum(numbers))
        } catch (e: IllegalArgumentException) {
            System.out.format(Constant.ERROR_MESSAGE, input)
            return
        }
    }
}

private fun exitCalculator(input: String) = input == "-1"