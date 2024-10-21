package calculator
import camp.nextstep.edu.missionutils.Console

class Calculator {
    var input: String = ""
    val separator = Separator()

    // calculator 초기화하는 함수
    private fun setInput() {
        println("덧셈할 문자열을 입력해주세요.")
        input = Console.readLine()
    }

    // 사용자 입력을 통해 합을 구하는 함수
    fun getSum(): Int {
        setInput()
        return separator.run(input).sum()
    }
}