package calculator

import calculator.view.InputView
import calculator.view.OutputView

class StringSumCalculator {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun start() {
        val splitResult = inputRequest()
    }

    private fun inputRequest(): List<String> {
        outputView.inputRequest()
        return inputView.inputCommend().getSplitResult()
    }
}
