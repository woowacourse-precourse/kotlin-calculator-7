package calculator

import calculator.constants.Message
import camp.nextstep.edu.missionutils.Console

class User {

    /**
     * 시작 메시지와 사용자의 입력을 받는 역할
     */
    fun enterString(): String {
        println(Message.START)
        return Console.readLine()
    }
}