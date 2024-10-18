package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // 사용자 입력
    val input = Console.readLine()

    // 구분자 리스트
    val delimiters = mutableListOf(",", ":")
    val customDelimiterRegex = Regex("^(//)(.*)(\\\\n).*")

    if (hasCustomDelimiter(customDelimiterRegex, input)) {
        val customDelimiter = getCustomDelimiter(customDelimiterRegex, input)
            ?: throw IllegalArgumentException("not found custom delimiter")
        delimiters.add(customDelimiter)
    }
}

fun hasCustomDelimiter(regex: Regex, input: String) = input.matches(regex)

fun getCustomDelimiter(regex: Regex, input: String) = regex.find(input)?.groupValues?.get(2)
