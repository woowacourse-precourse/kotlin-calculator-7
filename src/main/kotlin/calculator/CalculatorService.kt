package calculator

class CalculatorService(
    private val userInput: UserInput,
    private val guideOutput: GuideOutput,
    private val resultOutput: ResultOutput,
    private val calculator: Calculator,
    private val numberTokenizer: NumberTokenizer,
) {

    fun execute() {
        guideOutput.guideDelimiters()
        guideOutput.guideCustomDelimiters()
        guideOutput.guideAdditionInput()
        val input = userInput.getString()
        val numbers = numberTokenizer.tokenize(input)
        val customDelimiters = numberTokenizer.extractCustomDelimiters(input)
        val sum = calculator.sum(numbers)
        resultOutput.outputCustomDelimiters(customDelimiters)
        resultOutput.outputAddition(sum)
    }
}