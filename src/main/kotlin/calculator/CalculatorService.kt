package calculator

import java.math.BigDecimal

class CalculatorService(
    private val userInput: UserInput,
    private val guideOutput: GuideOutput,
    private val resultOutput: ResultOutput,
    private val calculator: Calculator,
    private val numberTokenizer: NumberTokenizer,
    private val delimiter: Delimiter
) {

    fun execute() {
        guideCalculator()
        val input = userInput.getString()
        val delimiters = delimiter.getDelimiters(input)
        val sum = calculateSum(input, delimiters)
        resultOutput.outputCustomDelimiters(delimiters)
        resultOutput.outputAddition(sum)
    }

    private fun guideCalculator() {
        guideOutput.guideDelimiters()
        guideOutput.guideCustomDelimiters()
        guideOutput.guideAdditionInput()
    }

    private fun calculateSum(input: String, delimiters: List<String>): BigDecimal {
        val numbers = numberTokenizer.tokenize(input, delimiters)
        return calculator.sum(numbers)
    }
}