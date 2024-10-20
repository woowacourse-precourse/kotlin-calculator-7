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

fun extractDelimiter(userInput: String): Pair<String, String> {
    return if (userInput.startsWith("//")) {
        val delimiterEndIndex = userInput.indexOf("\n")
        if (delimiterEndIndex != -1) {
            val customDelimiter = userInput.substring(2, delimiterEndIndex)
            val numbers = userInput.substring(delimiterEndIndex + 1)
            customDelimiter to numbers
        } else {
            "," to userInput
        }
    } else {
        "[,:]" to userInput
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

    if (parsedNumbers.isEmpty()) {
        throw IllegalArgumentException()
    }

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