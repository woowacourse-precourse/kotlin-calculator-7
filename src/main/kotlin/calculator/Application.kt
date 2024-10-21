package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    while (true) {
        try {
            println("덧셈할 문자열을 입력해 주세요.")
            val inputText = Console.readLine()
            val (inputNumbers, delimiters) = divideDelimiters(inputText)
            val numberList = divideNumbers(inputNumbers, delimiters)
            val sum = calculateSum(numberList)
            println(inputNumbers)
            println("결과 : $sum")
        } catch (e: IllegalArgumentException) {
            println(e.message)
            break
        }
    }
}

fun divideDelimiters(inputText: String): Pair<String, List<String>> {
    if (inputText.isEmpty()) {
        throw IllegalArgumentException("빈 문자열은 입력할 수 없습니다.")
    }

    return when {
        inputText.startsWith("//") -> {
            val customDelimiterEndIndex = inputText.indexOf("\\n")
            if (customDelimiterEndIndex == -1) {
                throw IllegalArgumentException("구분자 형식이 올바르지 않습니다.")
            }

            val customDelimiter = inputText.substring(2, customDelimiterEndIndex)
            val inputNumber = inputText.substring(customDelimiterEndIndex + 2)
            Pair(inputNumber, listOf(customDelimiter))
        }
        else -> {
            Pair(inputText, listOf(",", ":"))
        }
    }
}

fun divideNumbers(inputNumbers: String, delimiters: List<String>): List<String> {
    return inputNumbers.split(*delimiters.toTypedArray())
        .filter { it.isNotEmpty() }
        .map { it.trim() }
}

fun calculateSum(numberList: List<String>): Int {
    return numberList.sumOf { number ->
        val parsedNumber = number.toIntOrNull() ?: throw IllegalArgumentException("숫자 형식이 올바르지 않습니다.")
        if (parsedNumber < 0) {
            throw IllegalArgumentException("음수는 입력할 수 없습니다: $parsedNumber")
        }
        parsedNumber
    }
}