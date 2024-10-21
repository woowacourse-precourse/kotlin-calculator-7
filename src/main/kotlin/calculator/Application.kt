package calculator

fun main() {
    val userInput = UserInput()
    val guideOutput = GuideOutput()
    val resultOutput = ResultOutput()
    val calculator = Calculator()
    val numberTokenizer = NumberTokenizer()
    val delimiter = Delimiter()

    val calculatorService = CalculatorService(
        userInput = userInput,
        guideOutput = guideOutput,
        resultOutput = resultOutput,
        calculator = calculator,
        numberTokenizer = numberTokenizer,
        delimiter = delimiter
    )
    calculatorService.execute()
}
