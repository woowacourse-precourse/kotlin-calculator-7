package calculator

import calculator.constants.Message
import camp.nextstep.edu.missionutils.Console

class User {

    /**
     * 시작 메시지와 사용자의 입력을 담당하는 기능
     */
    fun enterString(): String {
        println(Message.START)
        return Console.readLine()
    }

    /**
     * 계산기를 선택하는 기능
     */
    fun setCalculator(operator: Operator): Calculator {
        return when (operator) {
            Operator.PLUS -> PlusCalculator()
        }
    }
}