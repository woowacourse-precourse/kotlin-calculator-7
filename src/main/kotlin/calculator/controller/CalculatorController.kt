package calculator.controller

import calculator.domain.Calculator
import calculator.view.InputView
import calculator.view.OutputView

class CalculatorController {
    private val inputView: InputView = InputView()
    private val outputView: OutputView = OutputView()

    fun start() {
        val userInput: String = inputView.inputAdditionString()
        val calculator = Calculator(userInput)
    }
}