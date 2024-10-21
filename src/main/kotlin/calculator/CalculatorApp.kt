package calculator

import calculator.model.Calculator
import calculator.utils.Extractor
import calculator.view.InputView
import calculator.view.OutputView

class CalculatorApp(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val calculator: Calculator
) {

    fun run() {
        val input = inputView.readString()
        val result = extract(input)
        val sum = calculate(result)
        displayResult(sum)
    }

    private fun extract(input: String): List<Int> = Extractor.extractNumbers(input)

    private fun calculate(input: List<Int>) = calculator.sum(input)

    private fun displayResult(sum: Int) = outputView.printResultOfSum(sum)

    companion object {
        fun create(
            inputView: InputView,
            outputView: OutputView,
            calculator: Calculator
        ): CalculatorApp = CalculatorApp(inputView, outputView, calculator)
    }
}