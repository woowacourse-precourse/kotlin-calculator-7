package calculator.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun inputExpression(): String {
        println("계산할 식을 입력해주세요.")
        return Console.readLine()
    }
}