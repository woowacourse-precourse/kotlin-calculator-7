package calculator

import camp.nextstep.edu.missionutils.Console

class Calculator {
    private val validator: Validator = Validator()
    private var result = 0

    fun turnOnCalculator() {
        println("덧셈할 문자열을 입력해 주세요.")
        val inputString: String = Console.readLine()
        val isInputStringEmpty: Boolean = validator.isInputStringEmpty(inputString)

        when (isInputStringEmpty) {
            true -> {
                println("결과 : 0")
                return
            }

            false -> {
                inputString.split(":", ",").map { result += it.toInt() }
                println("결과 : $result")
            }
        }
    }
}