package calculator

fun main() {
    val calculator = CalculatorImpl()
    calculator.start()
}

class CalculatorImpl {
    fun start() {
        println("덧셈할 문자열을 입력해 주세요.")
        process(readln())
    }
}