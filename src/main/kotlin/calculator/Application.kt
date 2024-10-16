package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
    var list : MutableList<Char> = mutableListOf(',',':')
    println("덧셈할 문자열을 입력해 주세요")
    var ans = Console.readLine()
    var calculator = Calculator(ans)
    calculator.findSeparator()
    calculator.findNumber()
    //calculator.plus()
    //calculator.print()
}
