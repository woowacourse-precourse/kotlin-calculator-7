package calculator

import calculator.view.InputView
import calculator.view.OutputView

class CalculatorApp(
    private val inputView: InputView,
    private val outputView: OutputView
) {

    fun run() {
        val input = inputView.readString()
        val result = calculate(input)

        outputView.printResultOfSum(result)
    }

    private fun calculate(input: List<Int>): Int {
        Calculator.sum(input)
        return Calculator.getResult()
    }
}