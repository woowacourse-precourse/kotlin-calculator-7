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

        if (result >= 0)
            outputView.resultPrompt(result)
        else
            outputView.exitPrompt()
    }

    private fun calculate(input: String): Int {
        val numbers = Delimiter(input).numberSplit()

        return if (numbers.isEmpty()) {
            -1
        } else {
            Calculate().getSum(numbers)
        }
    }
}