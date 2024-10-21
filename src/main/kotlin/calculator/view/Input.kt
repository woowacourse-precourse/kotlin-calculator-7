package calculator.view

import camp.nextstep.edu.missionutils.Console

class Input {
    fun inputSumCalculator(): String {
        println(INIT_START_SUM)
        return Console.readLine()
    }

    companion object {
        private const val INIT_START_SUM = "덧셈할 문자열을 입력해 주세요."
    }
}