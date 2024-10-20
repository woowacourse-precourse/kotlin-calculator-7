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
        } catch (e: IllegalArgumentException) {
            throw e
        }
    }
}