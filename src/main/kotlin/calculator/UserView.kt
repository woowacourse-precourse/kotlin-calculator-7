package calculator

import camp.nextstep.edu.missionutils.Console

private const val INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요."
private const val RESULT_MESSAGE = "결과 : "

class UserView {
    companion object {
        fun printStart() {
            println(INPUT_MESSAGE)
        }

        fun getStringInput(): String {
            return Console.readLine()
        }

        fun printResult(addResult: Int) {
            print("$RESULT_MESSAGE$addResult")
        }
    }
}