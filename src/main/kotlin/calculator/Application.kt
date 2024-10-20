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
    val result = calculator(input, defaultSeparators, customSeparatorPattern)
    println("결과 : $result")

}

fun calculator(input: String, defaultSeparators: List<String>, customSeparatorPattern: Regex): Long {
    // 입력 값이 비어있을 경우, 0을 반환
    if (input.isBlank()) return 0L

    // 커스텀 구분자가 있는지 확인하고, 없으면 기본 구분자만 사용
    val (separators, numbersPart) = extractCustomSeparator(input, defaultSeparators, customSeparatorPattern)

    // 구분자를 기준으로 숫자들을 추출
    val numbers = splitNumbers(numbersPart, separators)

    // 추출된 숫자들의 합을 반환
    return sumNumbers(numbers)
}

fun extractCustomSeparator(input: String, defaultSeparators: List<String>, customSeparatorPattern: Regex): Pair<List<String>, String> {
    val customSeparatorMatch = customSeparatorPattern.matchEntire(input)

    return if (customSeparatorMatch != null) {
        val customSeparator = customSeparatorMatch.groupValues[1]
        val numbersPart = customSeparatorMatch.groupValues[2]

        if (customSeparator.length != 1) {
            throw IllegalArgumentException()
        }
        if (customSeparator in defaultSeparators) {
            throw IllegalArgumentException()
        }
        if (customSeparator[0].isDigit()) {
            throw IllegalArgumentException()
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

fun sumNumbers(numbers: List<String>): Long {
    val negativeNumbers = numbers.filter { it.toLongOrNull()?.let { num -> num < 0 } == true }
    if (negativeNumbers.isNotEmpty()) {
        throw IllegalArgumentException()
    }

    return numbers
        .map { it.toLongOrNull() ?: throw IllegalArgumentException() }
        .sum()
}