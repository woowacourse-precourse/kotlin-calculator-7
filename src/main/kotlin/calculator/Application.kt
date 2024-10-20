package calculator

import calculator.domain.PositiveNumbersParser
import calculator.ui.Ui

fun main() {
    val ui = Ui()

    val userInput = ui.requestUserInput()
    val positiveNumbers = PositiveNumbersParser().parse(userInput)
    val sumOfPositiveNumbers = positiveNumbers.sum()

    ui.displaySum(sumOfPositiveNumbers)
}
