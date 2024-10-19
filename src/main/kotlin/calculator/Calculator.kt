package calculator

import camp.nextstep.edu.missionutils.Console

class Calculator {
    fun start() {
        printInput()
    }

    private fun printInput() = println(INPUT_MESSAGE)


    companion object {
        const val INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요."
    }
}