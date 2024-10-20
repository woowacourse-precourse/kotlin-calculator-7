package calculator

import camp.nextstep.edu.missionutils.Console

class Calculator {

    fun startCalculator() {
        println(CALCULATOR_INPUT_GUIDE_MESSAGE)

        val inputData: String = Console.readLine()

        println("출력: 입력값 -> $inputData")
    }

    companion object {
        const val CALCULATOR_INPUT_GUIDE_MESSAGE = "덧셈할 문자열을 입력해 주세요."
    }
}