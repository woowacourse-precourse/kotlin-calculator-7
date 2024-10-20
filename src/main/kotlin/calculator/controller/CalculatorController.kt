package calculator.controller

import calculator.model.Calculator
import calculator.model.Delimiter
import calculator.model.InputManager
import calculator.view.InputView
import calculator.view.OutputView

class CalculatorController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
) {

    fun calculateSumOfNumbers() {
        val input = inputView.readLine()

        if (input.isEmpty()) {
            outputView.printResult(0)
            return
        }

        val delimiter = Delimiter(input).getDelimiters()
        val manager = InputManager(delimiter)
        val nums = manager.removeCustomDelimiterDefinition(input).let { manager.findAllNumbers(it) }

        if (nums.isEmpty()) {
            outputView.printResult(0)
            return
        }

        manager.isContainNegativeNumber(nums)

        val result = Calculator().sum(nums)
        outputView.printResult(result)
    }
}