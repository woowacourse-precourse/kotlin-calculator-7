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

/**
 * 커스텀 구분자를 판별하고
 * 만약 있다면 반환, 없다면 null을 반환한다.
 */
private fun getCustomDelimiter(input: String): String? {
    val delimiterConditions = listOf("//", "\\n")
    var cnt = 0
    delimiterConditions.forEach { dc ->
        if (dc in input) cnt++
    }
    if (cnt != delimiterConditions.size) {
        return null
    }
    val customDelimiter = input.split(*delimiterConditions.toTypedArray())
    return customDelimiter[1]
}