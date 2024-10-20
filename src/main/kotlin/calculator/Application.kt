package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val userInput = Console.readLine()

    try {
        val result = calculateSum(userInput)
        println("결과 : $result")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}

fun extractDelimiter(userInput: String): Pair<Regex, String> {
    val customDelimiterRegex = """^//(.)\n(.*)$""".toRegex()
    val matchResult = customDelimiterRegex.find(userInput)

    return if (matchResult != null) {
        val customDelimiter = Regex.escape(matchResult.groupValues[1])
        val numbers = matchResult.groupValues[2]
        Regex(customDelimiter) to numbers
    } else {
        Regex("[,:]") to userInput
    }
}

fun calculateSum(userInput: String?): Int {
    if (userInput == null) {
        throw IllegalArgumentException("입력값이 없습니다.")
    }

    if (userInput.isEmpty()) {
        return 0
    }

    val (delimiter, numbers) = extractDelimiter(userInput)
    val parsedNumbers = numbers.split(delimiter)

    if (parsedNumbers.isEmpty()) {
        throw IllegalArgumentException("구분자와 양수로 구성된 문자열만 입력해주세요.")
    }

    return parsedNumbers
        .filter { it.isNotEmpty() }
        .map {
            val number = it.toIntOrNull()
                ?: throw IllegalArgumentException("구분자와 양수로 구성된 문자열만 입력해주세요.")
            require(number >= 0) { "구분자와 양수로 구성된 문자열만 입력해주세요." }
            number
        }
        .sum()
}