package calculator

import java.math.BigDecimal

class CalculatorService(
    private val userInput: UserInput,
    private val guideOutput: GuideOutput,
    private val resultOutput: ResultOutput,
    private val calculator: Calculator,
    private val numberTokenizer: NumberTokenizer,
) {

    fun execute() {
        guideCalculator()
        val input = userInput.getString()
        val customDelimiters = numberTokenizer.extractCustomDelimiters(input)
        val sum = calculateSum(input)
        resultOutput.outputCustomDelimiters(customDelimiters)
        resultOutput.outputAddition(sum)
    }

    private fun guideCalculator() {
        guideOutput.guideDelimiters()
        guideOutput.guideCustomDelimiters()
        guideOutput.guideAdditionInput()
    }

    private fun calculateSum(input: String): BigDecimal {
        val numbers = numberTokenizer.tokenize(input)
        return calculator.sum(numbers)
    }
}