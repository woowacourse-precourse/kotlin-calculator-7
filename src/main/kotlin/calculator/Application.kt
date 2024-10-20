package calculator

const val REQUEST_MESSAGE = "덧셈할 문자열을 입력해 주세요."
const val RESPONSE_MESSAGE = "결과 : "

fun main() {
    val defaultDelimiters = mutableSetOf(',', ':')
    val calculator = Calculator(REQUEST_MESSAGE, defaultDelimiters)
    calculator.printSum(RESPONSE_MESSAGE)
}
