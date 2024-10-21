package calculator

import calculator.controller.CalculatorController
import calculator.model.CalculatorModel
import calculator.view.CalculatorView

fun main() {
    val model = CalculatorModel()
    val view = CalculatorView()
    val controller = CalculatorController(model, view)

    controller.runCalculator()
}