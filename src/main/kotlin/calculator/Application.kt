package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {

    // 구분자 리스트 (쉼표, 콜론)
    val defaultSeparators = listOf(",", ":")

    // 커스텀 구분자 패턴 (문자열 앞부분에서 //와 \n 사이의 커스텀 구분자가 있는지 확인)
    val customSeparatorPattern = Regex("^//(.)\\\\n(.*)")

    // 사용자로부터 입력 받기
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine().trim('"', '\'')

    // 결과 처리
    try {
        val (separators, numbersPart) = extractCustomSeparator(input, defaultSeparators, customSeparatorPattern)
        val result = splitNumbers(numbersPart, separators)
        println("결과 : $result")
    } catch (e: IllegalArgumentException) {
        println("Error : ${e.message}")
    }
}

fun extractCustomSeparator(input: String, defaultSeparators: List<String>, customSeparatorPattern: Regex): Pair<List<String>, String> {
    val customSeparatorMatch = customSeparatorPattern.matchEntire(input)

    return if (customSeparatorMatch != null) {
        val customSeparator = customSeparatorMatch.groupValues[1]
        val numbersPart = customSeparatorMatch.groupValues[2]

        if (customSeparator.length != 1) {
            throw IllegalArgumentException("Custom delimiter must be a single character: $customSeparator")
        }
        if (customSeparator in defaultSeparators) {
            throw IllegalArgumentException("Custom delimiter cannot be a default delimiter (comma or colon): $customSeparator")
        }
        if (customSeparator[0].isDigit()) {
            throw IllegalArgumentException("Custom delimiter cannot be a digit: $customSeparator")
        }

        Pair(defaultSeparators + customSeparator, numbersPart)
    } else {
        Pair(defaultSeparators, input)
    }
}

fun splitNumbers(input: String, separators: List<String>): List<String> {
    val regex = separators.joinToString("|") { Regex.escape(it) }.toRegex()
    val result = input.split(regex).filter { it.isNotEmpty() }

    return result
}
