package calculator.view

import calculator.constants.INPUT_ADD_STRING
import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readString(): String {
        println(INPUT_ADD_STRING)
        val input = Console.readLine()
        return input
    }
}