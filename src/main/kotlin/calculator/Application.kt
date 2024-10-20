package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()

    val delimiterParser = DelimiterParser()
    val expression = delimiterParser.getExpression(input)
    val delimiterList = delimiterParser.getDelimiterList(input)
    val sum = Calculator(expression, delimiterList).calculateSum()

    print("결과 : $sum")
}