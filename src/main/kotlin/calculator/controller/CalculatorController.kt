package calculator.controller

import calculator.model.CalculatorModel
import calculator.view.CalculatorView

class CalculatorController(
    private val model: CalculatorModel,
    private val view: CalculatorView
) {
    fun runCalculator() {
        val input = view.getInput()
        val result = if (input.contains("//")) model.sumWithCustomSeparator(input) else model.sumWithDefaultSeparator(input)
        view.showResult(result)
    }
}