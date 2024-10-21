package calculator

import calculator.constants.Message
import camp.nextstep.edu.missionutils.Console

class User {

    fun enterString(): String {
        println(Message.START)
        return Console.readLine()
    }
}