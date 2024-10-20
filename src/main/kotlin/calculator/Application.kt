package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
    println("덧셈할 문자열을 입력해 주세요.")
    val userInput = Console.readLine() ?: ""

    try {
        val result = calculateSum(userInput)
        println("결과 : $result")
    } catch (e: IllegalArgumentException) {
        println("잘못된 값을 입력하였습니다.")
    }
}

fun extractDelimiter(userInput: String): Pair<Regex, String> {
    val customDelimiterRegex = """^//(.)\n(.*)$""".toRegex()
    val matchResult = customDelimiterRegex.find(userInput)

    return if (matchResult != null) {
        val customDelimiter = matchResult.groupValues[1]
        val numbers = matchResult.groupValues[2]
        Regex("[$customDelimiter,:]") to numbers
    } else {
        Regex("[,:]") to userInput
    }
}

fun calculateSum(userInput: String): Int {
    if (userInput.equals("")) return 0

    val (delimiter, numbers) = extractDelimiter(userInput)
    return numbers.split(delimiter)
        .map { it.toIntOrNull() ?: throw IllegalArgumentException("구분자와 양수로 구성된 문자열만 입력해주세요.") }
        .onEach { require(it >= 0) { "구분자와 양수로 구성된 문자열만 입력해주세요." } }
        .sum()
}