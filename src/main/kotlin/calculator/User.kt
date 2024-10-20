package calculator

import camp.nextstep.edu.missionutils.Console

class User {
    private val calculator = Calculator()

    fun run() {
        val input = readLine()

        when (isCustom(input)) {
            true -> calculator.calculateCustom(input)
            false -> calculator.calculate(input)
        }
    }

    private fun isCustom(input: String): Boolean {
        return input.contains(FRONT_SEPARATOR) && input.contains(LAST_SEPARATOR)
    }

    private fun readLine(): String {
        println(START_MESSAGE)
        return Console.readLine()
    }
}