package calculator

import calculator.model.Calculator
import calculator.view.InputView
import calculator.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val calculator = Calculator()
    CalculatorApp.create(inputView, outputView, calculator).run()
}
