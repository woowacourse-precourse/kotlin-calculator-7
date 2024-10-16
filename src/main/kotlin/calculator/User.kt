package calculator

import camp.nextstep.edu.missionutils.Console

class User {

    fun run() {
        println("덧셈할 문자열을 입력해 주세요.")
        enterString()
    }

    fun enterString(): String {
        val string = Console.readLine()
        return string
    }
}