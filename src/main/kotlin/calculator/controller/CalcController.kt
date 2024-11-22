package calculator.controller

import calculator.service.CalcService
import calculator.validator.InputValidator
import calculator.view.InputView
import calculator.view.OutputView

class CalcController(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun run() {
        val input = inputView.input()
        InputValidator.validateInput(input)
        val result = CalcService.getSum(input)
        outputView.printResult(result)
    }
}