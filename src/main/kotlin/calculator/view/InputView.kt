package calculator.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun printInputValueMessage() = println(INPUT_VALUE_MESSAGE)

    fun readLine(): String = Console.readLine().trim()

    companion object {
        private const val INPUT_VALUE_MESSAGE = "덧셈할 문자열을 입력해 주세요."
    }
}
