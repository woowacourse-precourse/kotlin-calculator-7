package Controller

import Model.Calculate
import Model.Delimiter
import View.InputView
import View.OutputView

class Controller {
    private val outputView = OutputView()
    fun runCalculator() {
        outputView.enterPrompt()
        val input = InputView().getInput()

        val result = calculate(input)

        outputView.resultPrompt(result)
    }

    private fun calculate(input: String): Int {
        val numbers = Delimiter(input).numberSplit()

        return Calculate().getSum(numbers)
    }
}