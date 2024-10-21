package calculator

import calculator.domain.Calculator
import calculator.view.InputView
import calculator.view.OutputView

fun main() {
    val calculator = Calculator()
    val inputView = InputView()
    val outputView = OutputView()
    val controller = CalculatorController(calculator, inputView, outputView)
    try {
        controller.run()
    } catch (e: Exception) {
        throw e
    }
}
