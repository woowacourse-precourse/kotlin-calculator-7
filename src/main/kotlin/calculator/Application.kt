package calculator

import camp.nextstep.edu.missionutils.Console
import java.math.BigDecimal

fun main() {
    val delimiterExtractor = DelimiterExtractor()
    val calculator = Calculator(delimiterExtractor)

    print("덧셈할 문자열 입력: ")
    val userInput = Console.readLine()
    val result: BigDecimal = calculator.add(userInput)

    println("결과 : $result")

}
