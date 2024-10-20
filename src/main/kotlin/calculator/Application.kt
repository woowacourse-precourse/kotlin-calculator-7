package calculator

import calculator.controller.CalculatorController
import calculator.domain.Calculator
import calculator.view.InputView
import calculator.view.OutputView

fun main() {
    CalculatorController(
        inputView = InputView(),
        outputView = OutputView(),
        calculator = Calculator()
    ).run()
}
