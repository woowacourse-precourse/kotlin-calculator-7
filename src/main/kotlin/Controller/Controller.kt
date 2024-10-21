package Controller

import Model.Calculate
import Model.Delimiter
import View.InputView
import View.OutputView

class Controller {
    fun runCalculator() {
        OutputView().enterPrompt()
        val input = InputView().getInput()
        val result = calculate(input)
    }

    private fun calculate(input: String): Int {
        val numbers = Delimiter().numberSplit(input)
        return Calculate().getSum(numbers)
    }
}