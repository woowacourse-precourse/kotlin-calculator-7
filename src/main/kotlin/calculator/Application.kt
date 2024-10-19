package calculator

fun main() {
    val userInput = UserInput()
    val guideOutput = GuideOutput()
    val resultOutput = ResultOutput()
    val calculator = Calculator()
    val numberTokenizer = NumberTokenizer()

    val calculatorService = CalculatorService(
        userInput = userInput,
        guideOutput = guideOutput,
        resultOutput = resultOutput,
        calculator = calculator,
        numberTokenizer = numberTokenizer
    )
    calculatorService.execute()
}
