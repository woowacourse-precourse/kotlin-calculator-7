package calculator.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readString(): List<Int> {
        // TODO: 예외 처리
        println(INPUT_ADD_STRING)
        val input = Console.readLine()

        return input.split(",", ":").map { it.toInt() }
    }

    companion object {
        const val INPUT_ADD_STRING = "덧샘할 문자열을 입력해 주세요."
    }
}