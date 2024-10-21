package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val strInput = Console.readLine()
    println("입력값: $strInput")
}

fun splitNumbers(input: String): List<String> {
    return input.split(",", ":")
}