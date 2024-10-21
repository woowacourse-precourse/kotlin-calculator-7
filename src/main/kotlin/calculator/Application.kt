package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val inputText = Console.readLine()
    val (inputNumbers, delimiters) = divideDelimiters(inputText)
    println(delimiters)
}

fun divideDelimiters(inputText: String): Pair<String, List<String>> {
    return when {
        inputText.startsWith("//") -> {
            val customDelimiterEndIndex = inputText.indexOf("\\n")
            val customDelimiter = inputText.substring(2, customDelimiterEndIndex)
            val inputNumber = inputText.substring(customDelimiterEndIndex + 2)
            Pair(inputNumber, listOf(customDelimiter))
        }
        else -> {
            Pair(inputText, listOf(",", ":"))
        }
    }
}