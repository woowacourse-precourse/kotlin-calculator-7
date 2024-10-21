package calculator

class CalculatorController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        try {
            val input = inputView.getInput()
            val result = AddCalculator().calculate(input)
            outputView.displayResult(result)
        }catch (e: Exception) {
            println(e.message)
        }

    }
}