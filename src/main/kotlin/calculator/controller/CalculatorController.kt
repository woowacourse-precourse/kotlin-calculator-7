package calculator.controller

import calculator.domain.Calculator
import calculator.view.InputView
import calculator.view.OutputView

class CalculatorController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val calculator: Calculator
) {
    fun run() {
        inputView.printInputValueMessage()
        val inputValue = inputView.readLine()
        val result = calculator.sum(inputValue)
        outputView.printResultMessage(result)
    }
}
