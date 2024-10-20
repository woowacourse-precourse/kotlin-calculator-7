package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현


    val parser = Parser()

    println("계산할 문자열을 입력하시오... (ex: 1,2,3 또는 //;\n1;2;3): ")
    val input = Console.readLine()
    val result = parser.parse(input)
    println(result)
}

class Parser {
    fun parse(input: String?): List<Int> {
        if (input.isNullOrEmpty()) {
            return listOf(0)
        }
        return input.split(",", ":").map { it.toInt() }
    }
}