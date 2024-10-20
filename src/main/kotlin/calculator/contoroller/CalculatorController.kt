package calculator

import calculator.Input
import calculator.model.SumCalculator

class CalculatorController {
    private var userStringData : String

    init{
        userStringData = readyUserStringData()
    }

    private fun readyUserStringData(): String{
        return Input.inputStringData()
    }

    fun run() {
        try {
            val stringParser = StringParser(userStringData)
            val numberList = stringParser.getNumberList()

            val sumCalculator = SumCalculator(numberList)
            val sum = sumCalculator.getSum()
            println("결과 : $sum")
        } catch (e: IllegalArgumentException) {
            throw e
        }
    }
}