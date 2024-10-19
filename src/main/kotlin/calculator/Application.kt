package calculator

import camp.nextstep.edu.missionutils.Console.readLine

private val DEFAULT_DELIMITERS = listOf(",", ":")
private val DELIMITERS_CONDITIONS = listOf("//", "\\n")

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")

    val input = readLine()
    val customDelimiters = getCustomDelimiter(input)
    val finalDelimiters = createFinalDelimiters(customDelimiters)
    val inputStringList = splitByDelimiters(input, finalDelimiters)
    val inputIntList = inputStringList.map { it.toInt() }
    val sumOfIntList = inputIntList.sum()

    println("결과 : $sumOfIntList")
}

// 구분자를 기준으로 문자열을 나눈다.
private fun splitByDelimiters(
    input: String,
    delimiters: List<String>,
): List<String> {
    val removedPrefixInput = input.split(DELIMITERS_CONDITIONS[1]).last()
    return removedPrefixInput.split(*delimiters.toTypedArray())
}

/**
 * 커스텀 구분자를 판별하고
 * 만약 있다면 반환, 없다면 null을 반환한다.
 */
private fun getCustomDelimiter(input: String): String? {
    var cnt = 0
    DELIMITERS_CONDITIONS.forEach { dc ->
        if (dc in input) cnt++
    }
    if (cnt != DELIMITERS_CONDITIONS.size) {
        return null
    }
    val customDelimiter = input.split(*DELIMITERS_CONDITIONS.toTypedArray())
    return customDelimiter[1]
}

// 최종적으로 사용할 구분자 리스트를 만든다.
fun createFinalDelimiters(customDelimiter: String?): List<String> {
    if (customDelimiter == null) return DEFAULT_DELIMITERS
    val mutableDefaultDelimiters = DEFAULT_DELIMITERS.toMutableList()
    mutableDefaultDelimiters.add(customDelimiter)
    return mutableDefaultDelimiters
}