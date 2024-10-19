package calculator

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    val input = readLine()
    val inputStringList = splitWithDefaultDelimiters(input)
    val inputIntList = inputStringList.map { it.toInt() }
    val sumOfIntList = inputIntList.sum()
    println(sumOfIntList)
}

// 기본 구분자를 기준으로 문자열을 나눈다.
private fun splitWithDefaultDelimiters(input: String): List<String> {
    val defaultDelimiters = listOf(",", ":")
    return input.split(*defaultDelimiters.toTypedArray())
}

