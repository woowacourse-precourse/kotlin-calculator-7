package calculator

import calculator.domain.SumCalculator
import calculator.view.InputView
import calculator.view.OutputView
import calculator.view.ResultFormatter

class StringSumCalculator {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun start() {
        val total = SumCalculator(inputRequest()).calculateTotal()
        val formatResult = ResultFormatter(total).formatResult()
    }

    private fun inputRequest(): List<String> {
        outputView.inputRequest()
        return inputView.inputCommend().getSplitResult()
    }
}
