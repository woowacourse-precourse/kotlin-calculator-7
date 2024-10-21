package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {

    // TODO : 프로그램 구현

    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()
    val result = add(input)
    println("결과 : $result")
}

fun add(input: String?): Int {
    if (input.isNullOrEmpty()) {
        return 0
    }

    var numbers = input
    var delimiters = arrayOf(",", ":")

    if (input.startsWith("//")) {
        val delimiterEnd = input.indexOf("\n")

        if (delimiterEnd == -1) {
            throw IllegalArgumentException("Invalid input format: 줄바꿈 문자가 필요합니다.")
        }

        val customDelimiter = input.substring(2, delimiterEnd)
        delimiters += customDelimiter
        numbers = input.substring(delimiterEnd + 1)
    }

    val tokens = numbers.split(*delimiters)

    val numberList = tokens.map {
        try {
            it.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Invalid input: $it")
        }
    }

    val negativeNumbers = numberList.filter { it < 0 }
    if (negativeNumbers.isNotEmpty()) {
        throw IllegalArgumentException("Negative numbers not allowed: $negativeNumbers")
    }

    return numberList.sum()
}