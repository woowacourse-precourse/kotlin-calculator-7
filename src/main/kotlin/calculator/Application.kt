package calculator

import camp.nextstep.edu.missionutils.Console.readLine

private val DEFAULT_DELIMITERS = listOf(",", ":")
private val DELIMITERS_CONDITIONS = listOf("//", "\\n")
private const val INPUT_NOTICE_TEXT = "덧셈할 문자열을 입력해 주세요."
private const val RESULT_TEXT = "결과 : "

fun main() {
    println(INPUT_NOTICE_TEXT)

    val input = readLine().validate()
    val customDelimiters = getCustomDelimiter(input)
    val finalDelimiters = createFinalDelimiters(customDelimiters)
    val inputStringList = splitByDelimiters(input, finalDelimiters)
    val inputIntList = inputStringList.toIntList()
    val sumOfIntList = inputIntList.sum()

    println(RESULT_TEXT + sumOfIntList)
}

// 커스텀 구분자를 판별하고 만약 있다면 반환, 없다면 null을 반환한다.
private fun getCustomDelimiter(input: String): String? {
    if (input.findCustomDelimiter()) {
        return null
    }
    val customDelimiter = input.split(*DELIMITERS_CONDITIONS.toTypedArray())
    if (customDelimiter[1].isEmpty()) {
        throw IllegalArgumentException()
    }
    return customDelimiter[1]
}

private fun String.findCustomDelimiter(): Boolean {
    var cnt = 0
    DELIMITERS_CONDITIONS.forEach { dc ->
        if (dc in this) cnt++
    }
    return cnt != DELIMITERS_CONDITIONS.size
}

// 구분자를 기준으로 문자열을 나눈다.
private fun splitByDelimiters(
    input: String,
    delimiters: List<String>,
): List<String> {
    val removedPrefixInput =
        input
            .split(DELIMITERS_CONDITIONS[1])
            .last()
    return removedPrefixInput.split(*delimiters.toTypedArray())
}

// 최종적으로 사용할 구분자 리스트를 만든다.
fun createFinalDelimiters(customDelimiter: String?): List<String> {
    if (customDelimiter == null) {
        return DEFAULT_DELIMITERS
    }
    val mutableDefaultDelimiters = DEFAULT_DELIMITERS.toMutableList()
    mutableDefaultDelimiters.add(customDelimiter)
    return mutableDefaultDelimiters
}

// 입력 값에 대한 기본적인 유효성 검사
fun String.validate(): String =
    when {
        this.isEmpty() -> throw IllegalArgumentException()
        else -> this
    }

// 문자열 리스트를 정수형 리스트로 변환해준다.
fun List<String>.toIntList(): List<Int> =
    this.map {
        val intValue = it.toIntOrNull()
        if (intValue == null || intValue < 0) {
            throw IllegalArgumentException()
        }
        intValue
    }
