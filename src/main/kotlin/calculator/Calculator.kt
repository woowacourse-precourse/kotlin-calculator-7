package calculator

import kotlin.IllegalArgumentException

class Calculator {

    fun calculate(input: String) {
        val splitInput = input.split(COMMA, COLON)
        validateInput(splitInput)
        printResult(splitInput.sumOf { it.toBigInteger() }.toString())
    }

    fun calculateCustom(input: String) {
        val (customSeparator, customInput) = input
            .split(FRONT_SEPARATOR, LAST_SEPARATOR)
            .filter { it.isNotEmpty() }
        validateInputCustom(customSeparator, customInput)
        val splitInput = customInput.split(customSeparator)
        printResult(splitInput.sumOf { it.toBigInteger() }.toString())
    }

    private fun validateInput(splitInput: List<String>) {
        splitInput.forEach {
            if (it.toBigIntegerOrNull() == null) throw IllegalArgumentException(INPUT_VALIDATE_MESSAGE)
            if (it.first() == MINUS) throw IllegalArgumentException(INPUT_VALIDATE_MESSAGE)
        }
    }

    private fun validateInputCustom(customSeparator: String, customInput: String) {
        if (customSeparator.length != 1) throw IllegalArgumentException(CUSTOM_INPUT_VALIDATE_MESSAGE)
        if (customSeparator.first().isDigit()) throw IllegalArgumentException(CUSTOM_INPUT_VALIDATE_MESSAGE)

        validateInput(customInput.split(customSeparator))
    }

    private fun printResult(result: String) {
        println("$RESULT_STRING$result")
    }
}