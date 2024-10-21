package calculator

fun main() {
    // TODO: 프로그램 구현
    val inputView = InputView()
    val outputView = OutputView()
    val calculator = AddCalculator()
    val controller = CalculatorController(inputView, outputView, calculator)

    controller.run()
}
