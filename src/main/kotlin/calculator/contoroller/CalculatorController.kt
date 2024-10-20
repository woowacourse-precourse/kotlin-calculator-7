package calculator

import calculator.Input

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
        } catch (e: IllegalArgumentException) {
            throw e
        }
    }
}