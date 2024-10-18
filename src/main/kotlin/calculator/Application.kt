package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // 사용자 입력
    val input = Console.readLine()

    // 구분자 리스트
    val delimiters = mutableListOf(",", ":")
    val customDelimiterRegex = Regex("^(//)(.*)(\\\\n).*")

    var parsedInput = input
    if (hasCustomDelimiter(customDelimiterRegex, input)) {
        val customDelimiter = getCustomDelimiter(customDelimiterRegex, input)
            ?: throw IllegalArgumentException("not found custom delimiter")
        delimiters.add(customDelimiter)
        parsedInput = input.substring(customDelimiter.length + 4)
    }

    // 숫자 추출
    try {
        val numbers = splitByDelimiters(parsedInput, delimiters).toNumbers()
        println(numbers)
    } catch (e: Exception) {
        throw IllegalArgumentException("unable to extract numbers")
    }
}

fun hasCustomDelimiter(regex: Regex, input: String) = input.matches(regex)

fun getCustomDelimiter(regex: Regex, input: String) = regex.find(input)?.groupValues?.get(2)

fun splitByDelimiters(input: String, delimiters: List<String>) = input.split(*delimiters.toTypedArray()).filter { it.isNotBlank() }

fun List<String>.toNumbers() = this.map { it.toInt() }
