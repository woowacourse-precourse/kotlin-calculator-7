package calculator.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    private const val INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요."

    fun getUserInput(): String {
        println(INPUT_MESSAGE)
        return Console.readLine()
    }
}
