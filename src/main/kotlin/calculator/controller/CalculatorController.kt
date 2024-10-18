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

        val delimiter = Delimiter(input).getDelimiters()

        val manager = InputManager(delimiter)
        val nums = manager.removeCustomDelimiterDefinition(input).let { manager.findAllNumbers(it) }
        manager.isContainNegativeNumber(nums)

        val result = Calculator(nums).getResult()
        outputView.printResult(result)
    }
}