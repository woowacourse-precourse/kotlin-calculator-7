package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    var result = 0

    val splitInput = listOf<Int>()
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()

    if (input.isBlank()){
        result = 0
    }

    if (input.contains(",") || input.contains(":")) {
        // , 또는 : 구분자를 기준으로 분리한다.
        val numFromInput= input.split(",",":").map { it.toInt() }
        println(numFromInput)
    }
}
