package calculator

import calculator.domain.Calculator
import calculator.view.InputView
import calculator.view.OutputView

class CalculatorController(
    private val calculator: Calculator,
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun run() {
        try {
            val input = inputView.inputExpression()
            val result = calculator.add(input)
            outputView.showResult(result)
        } catch (e: IllegalArgumentException) {
            outputView.showError(e.message ?: "알 수 없는 에러가 발생했습니다.")
            throw e
        }
    }
}