package calculator

import calculator.view.InputView
import calculator.view.OutputView

class CalculatorApp(
    private val inputView: InputView,
    private val outputView: OutputView
) {

    fun run() {
        val input = inputView.readString()
        val result = extract(input)
        val sum = calculate(result)
        displayResult(sum)
    }

    private fun extract(input: String): List<Int> {
        val result = Extractor.extractNumbers(input)
        return result
    }

    private fun calculate(input: List<Int>): Int {
        Calculator.sum(input)
        return Calculator.getResult()
    }

    private fun displayResult(sum: Int) = outputView.printResultOfSum(sum)
}