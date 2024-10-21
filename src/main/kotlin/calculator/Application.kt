package calculator

import camp.nextstep.edu.missionutils.Console.readLine

val delimiter = mutableListOf(",", ":")
var sum = 0

fun main() {
    val input = getInput()

    if (input.startsWith("//")) {
        makeCustomDelimiter(input)
    }

    calculateSum(extractNumber(input))

    println("결과 : $sum")
}

fun getInput(): String {
    println("덧셈할 문자열을 입력해 주세요.")

    return readLine()
}

fun extractNumber(input: String): List<String> {
    return input.substringAfter("\\n").split(*delimiter.toTypedArray())
}

fun makeCustomDelimiter(input: String) {
    val startIndex = input.indexOf("//")
    val endIndex = input.indexOf("\\n")
    if (endIndex == -1) {
        throw IllegalArgumentException("wrong input")
    }
    val customDelimiter = input.substring(startIndex, endIndex)
    delimiter.add(customDelimiter)
}

fun calculateSum(numList: List<String>): Int {
    return numList.sumOf {
        val num = it.toIntOrNull() ?: throw IllegalArgumentException("wrong input")
        if (num < 0) throw IllegalArgumentException("wrong input")

        num
    }}
