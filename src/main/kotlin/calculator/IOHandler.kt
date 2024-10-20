package calculator

class IOHandler {
    fun inputNumber(): String? {
        println("덧셈할 문자열을 입력해 주세요.")
        val input = readLine()

        return input
    }

    fun printSum(sum: Int) {
        println("결과 : $sum")
    }
}