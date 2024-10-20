package calculator

import calculator.utils.Calculator
import camp.nextstep.edu.missionutils.Console.readLine

/**메인문 내부에서는 입출력만 수행*/
fun main() {
    // 입력 받기
    println("덧셈할 문자열을 입력해 주세요.")
    val input = readLine()
    val result = Calculator.calculateString(input)
    println(result)
}