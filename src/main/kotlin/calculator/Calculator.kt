package calculator
import camp.nextstep.edu.missionutils.Console

class Calculator {
    var input: String? = null
    var result: Int = 0

    // calculator 초기화
    private fun init() {
        println("덧셈할 문자열을 입력해주세요.")
        input = Console.readLine()
    }

    fun getSum(): Int {
        init()
        if (input.isNullOrBlank()) return 0

        return result
    }
}