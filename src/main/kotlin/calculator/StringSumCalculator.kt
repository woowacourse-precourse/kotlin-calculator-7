package calculator

import calculator.domain.SumCalculator
import calculator.view.InputView
import calculator.view.OutputView

class StringSumCalculator {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun start() {
        val splitResult = inputRequest()
        val result = SumCalculator(splitResult).calculateTotal()
        outputView.printSumResult(result)
    }

    private fun inputRequest(): List<String> {
        outputView.inputRequest()
        return inputView.inputCommend().commendSplit()
    }
}
