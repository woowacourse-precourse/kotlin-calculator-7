package calculator

import camp.nextstep.edu.missionutils.Console.readLine

val standard = mutableListOf(",", ":")

fun main() {
    val input = getInput()

}

fun getInput(): String {
    println("덧셈할 문자열을 입력해 주세요.")

    return readLine()
}

fun extractNumber(input: String): List<String> {
    return input.split(*standard.toTypedArray())
}
