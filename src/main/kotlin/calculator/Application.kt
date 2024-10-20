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

fun extractDelimiter(userInput: String): Pair<List<Char>, String> {
    return if (userInput.startsWith("//")) {
        val customDelimiter = userInput[2]
        val numbers = userInput.substringAfter("\n")
        listOf(customDelimiter) to numbers
    } else {
        listOf(',', ':') to userInput
    }
}

fun calculateSum(userInput: String?): Int {
    if (userInput == null) {
        throw IllegalArgumentException()
    }

    if (userInput.isEmpty()) {
        return 0
    }

    val (delimiter, numbers) = extractDelimiter(userInput)
    val parsedNumbers = numbers.split(delimiter)

    return parsedNumbers
        .filter { it.isNotEmpty() }
        .map {
            val number = it.toIntOrNull()
                ?: throw IllegalArgumentException()
            require(number >= 0)
            number
        }
        .sum()
}