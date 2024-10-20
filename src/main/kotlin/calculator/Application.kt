package calculator

import camp.nextstep.edu.missionutils.Console.readLine


fun main() {
    val defaultDelimiters = mutableSetOf(',', ':')
    val calculator = Calculator("덧셈할 문자열을 입력해 주세요.", defaultDelimiters)
    calculator.printSum("결과 : ")
}
