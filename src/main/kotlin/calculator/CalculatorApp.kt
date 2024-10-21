package calculator

import calculator.view.Input
import calculator.view.Output

class CalculatorApp {
    private val inputHandler = Input()
    private val outputHandler = Output()
    private val separatorHandler = Separator()
    private val calculatorHandler = Calculator()

    fun run() {
        val originInput: String = inputHandler.inputSumCalculator()
        val (parsedInput, updatedSeparators) = separatorHandler.extractCustomSeparator(originInput)
        val sumResult: Int = calculatorHandler.calculateSum(parsedInput, updatedSeparators)
        if (originInput.isBlank()) {
            outputHandler.printCalculateResult(0)
            return
        }
        outputHandler.printCalculateResult(sumResult)
    }
}