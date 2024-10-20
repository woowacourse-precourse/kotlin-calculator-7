package calculator.controller

import calculator.model.Calculator
import calculator.model.Delimiter
import calculator.model.InputParser
import calculator.view.InputView
import calculator.view.OutputView

class CalculatorController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
) {

    fun sumNumbers() {
        val userInput = inputView.readLine()

        if (userInput.isEmpty()) {
            outputView.printResult(0)
            return
        }

        val delimiters = Delimiter(userInput).getDelimiters()
        val inputManager = InputParser(delimiters)

        val numbers = inputManager.removeDelimiterDefinition(userInput)
            .let { inputManager.extractNumbers(it) }

        if (numbers.isEmpty()) {
            outputView.printResult(0)
            return
        }

        inputManager.containNegativeNumber(numbers)

        val sumResult = Calculator().sum(numbers)
        outputView.printResult(sumResult)
    }
}