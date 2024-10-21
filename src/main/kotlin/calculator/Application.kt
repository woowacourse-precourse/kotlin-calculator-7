package calculator

import camp.nextstep.edu.missionutils.Console.readLine

val standard = mutableListOf(",", ":")
var sum = 0

fun main() {
    val input = getInput()

    if (input.startsWith("//")) {
        makeCustomStandard(input)
    }

    println("결과 : $sum")
}

fun getInput(): String {
    println("덧셈할 문자열을 입력해 주세요.")

    return readLine()
}

fun extractNumber(input: String): List<String> {
    return input.substringAfter("\\n").split(*standard.toTypedArray())
}

fun makeCustomStandard(input: String) {
    val startIndex = input.indexOf("//")
    val endIndex = input.indexOf("\\n")
    if (endIndex == -1) {
        throw IllegalArgumentException("wrong input")
    }
    val customStandard = input.substring(startIndex, endIndex)
    standard.add(customStandard)
}

fun calculateSum(numList: List<String>): Int {
    return numList.sumOf {
        it.toInt()
    }}
