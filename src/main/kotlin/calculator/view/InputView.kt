package calculator.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun inputAdditionString(): String {
        println(INPUT_MESSAGE)
        return Console.readLine()
    }

    companion object {
        private const val INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요."
    }
}