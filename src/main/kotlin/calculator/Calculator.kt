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
        return result
    }
}