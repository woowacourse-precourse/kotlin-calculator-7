package calculator

import camp.nextstep.edu.missionutils.Console.readLine

val delimiter = mutableListOf(",", ":")

fun main() {
    val input = getInput()

    if (input.startsWith("//")) {
        makeCustomDelimiter(input)
    }

    println("결과 : ${calculateSum(extractNumber(input))}")
}

fun getInput(): String {
    println("덧셈할 문자열을 입력해 주세요.")

    return readLine()
}

fun extractNumber(input: String): List<String> {
    if (input == "") return listOf("0")

    return input.substringAfter("\\n").split(*delimiter.toTypedArray())
}

fun makeCustomDelimiter(input: String) {
    val startIndex = input.indexOf("//")
    val endIndex = input.indexOf("\\n")
    if (endIndex == -1) {
        throw IllegalArgumentException("wrong input")
    }
    val customDelimiter = input.substring(startIndex+2, endIndex)
    delimiter.add(customDelimiter)
}

fun calculateSum(numList: List<String>): Int {
    return numList.sumOf {
        val num = it.toIntOrNull() ?: throw IllegalArgumentException("wrong input")
        if (num < 0) throw IllegalArgumentException("wrong input")

        num
    }}
