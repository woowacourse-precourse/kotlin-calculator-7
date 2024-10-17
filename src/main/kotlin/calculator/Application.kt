package calculator

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    val input = i()
}

private fun i(): String {
    println(START_MESSAGE)
    return readLine()
}

private const val START_MESSAGE = "덧셈할 문자열을 입력해 주세요."