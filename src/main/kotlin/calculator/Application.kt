package calculator

import camp.nextstep.edu.missionutils.Console.readLine

private val DEFAULT_DELIMITERS = listOf(",", ":")

fun main() {
    val input = readLine()
    val inputStringList = splitByDelimiters(input)
    val inputIntList = inputStringList.map { it.toInt() }
    val sumOfIntList = inputIntList.sum()
    println(sumOfIntList)
}

// 구분자를 기준으로 문자열을 나눈다.
private fun splitByDelimiters(input: String): List<String> {
    return input.split(*DEFAULT_DELIMITERS.toTypedArray())
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