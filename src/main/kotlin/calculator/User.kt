package calculator

import camp.nextstep.edu.missionutils.Console

class User {

    fun enterString(): String {
        println("덧셈할 문자열을 입력해 주세요.")
        return Console.readLine()
    }
}