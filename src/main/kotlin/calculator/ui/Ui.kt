package calculator.ui

import camp.nextstep.edu.missionutils.Console

class Ui {
    fun requestUserInput(): String {
        println("덧셈할 문자열을 입력해 주세요.")
        return Console.readLine()
    }
}