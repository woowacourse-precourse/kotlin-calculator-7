package calculator.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readLine(): String {
        println(REQUEST_MESSAGE)

        val input = Console.readLine()
        Console.close()

        return input
    }

    companion object {
        private const val REQUEST_MESSAGE = "덧셈할 문자열을 입력해 주세요."
    }
}