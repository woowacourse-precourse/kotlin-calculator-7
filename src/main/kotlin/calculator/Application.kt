package calculator

fun main() {
    val userInput = UserInput()
    val guideOutput = GuideOutput()
    val resultOutput = ResultOutput()
    val calculator = Calculator()
    val numberTokenizer = NumberTokenizer()

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
