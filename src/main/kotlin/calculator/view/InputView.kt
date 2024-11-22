package calculator.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun input(): String {
        println(INPUT_MSG)
        return Console.readLine()
    }

    companion object {
        private const val INPUT_MSG = "덧셈할 문자열을 입력해 주세요."
    }
}