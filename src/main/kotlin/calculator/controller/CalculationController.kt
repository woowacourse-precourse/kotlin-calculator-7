package calculator.controller

import calculator.model.Calculator
import calculator.model.Parser
import calculator.util.Validator
import calculator.view.InputView
import calculator.view.OutputView

class CalculationController {
    fun start() {
        val userInput = getInput()
        val numbers = parseInput(userInput)
        val result = calculateResult(numbers)
        showResult(result)
    }

    private fun getInput(): String {
        val input = InputView.getUserInput()
        Validator.validateInput(input)
        return input
    }

    private fun parseInput(input: String): List<Int> {
        val parser = Parser()
        return parser.parse(input)
    }

    private fun calculateResult(numbers: List<Int>): Int {
        val calculator = Calculator()
        return calculator.calculate(numbers)
    }

    private fun showResult(result: Int) {
        OutputView.printResult(result)
    }
}
