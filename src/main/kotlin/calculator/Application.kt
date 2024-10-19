package calculator

import calculator.view.InputView
import calculator.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    CalculatorApp(inputView, outputView).run()
}
