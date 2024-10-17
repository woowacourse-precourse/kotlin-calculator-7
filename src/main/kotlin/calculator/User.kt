package calculator

import camp.nextstep.edu.missionutils.Console

class User {
    private val calculator = Calculator()

    fun run() {
        // 입력 받기
        val input = readLine()

    }

    private fun readLine(): String {
        println("덧셈할 문자열을 입력해 주세요.")
        return Console.readLine()
    }
}