package calculator
import camp.nextstep.edu.missionutils.Console

class Calculator {
    var input: String? = null
    var result: Int = 0

    // calculator 초기화
    fun init() {
        input = Console.readLine()
    }

    fun getSum(): Int {
        println("덧셈할 문자열을 입력해주세요.")
        return result
    }
}