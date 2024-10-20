package calculator

import camp.nextstep.edu.missionutils.Console

class Calculator {
    private val separator: Separator = Separator()

    fun startCalculator() {
        println(CALCULATOR_INPUT_GUIDE_MESSAGE)

        getUserInput()
    }

    private fun getUserInput() {
        val inputData: String = Console.readLine()

        val splitResult: List<String> = separator.splitSeparator(inputData)
        println("출력: 입력 분리값 -> $splitResult")
    }

    companion object {
        const val CALCULATOR_INPUT_GUIDE_MESSAGE = "덧셈할 문자열을 입력해 주세요."
    }
}