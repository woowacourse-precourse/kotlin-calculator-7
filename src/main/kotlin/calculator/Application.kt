package calculator

import calculator.controller.CalcController
import calculator.view.InputView
import calculator.view.OutputView

fun main() {
    CalcController(InputView(), OutputView()).run()
}