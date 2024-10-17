package calculator

import camp.nextstep.edu.missionutils.Console

class User {
    private val calculator = Calculator()

    fun run() {
        // 입력 받기
        val input = readLine()

        when (isCustom(input)) {
            true -> {
                calculator.calculateCustom(input)
            }

            false -> {
                calculator.calculate(input)
            }
        }

    }

    private fun isCustom(input: String): Boolean {
        val custom = input.take(CUSTOM_COUNT)
        return custom.contains("//") && custom.contains("\\n")
    }

    private fun readLine(): String {
        println("덧셈할 문자열을 입력해 주세요.")
        return Console.readLine()
    }
}