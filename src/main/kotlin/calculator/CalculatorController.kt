package calculator

class CalculatorController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val addCalculator: AddCalculator
) {
    fun run() {
        try {
            val input = inputView.getInput()
            val result = addCalculator.calculate(input)
            outputView.displayResult(result)
        }catch (e: Exception) {
            println(e.message)
        }

    }
}