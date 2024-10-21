package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val strInput = Console.readLine()

    // \n을 개행 문자로 바꿔주기
    val formattedInput = strInput.replace("\\n", "\n")

    val result = addNumbers(formattedInput)
    println("결과: $result")
}

fun addNumbers(input: String): Int {
    val (delimiter, numbers) = parseInput(input)
    val numberList = splitNumbers(numbers, delimiter)
    return numberList.sumOf { it.toInt() }
}

fun parseInput(input: String): Pair<String, String> {
    return if (input.startsWith("//")) {
        val delimiterEndIndex = input.indexOf("\n")
        val customDelimiter = input.substring(2, delimiterEndIndex)
        val numbers = input.substring(delimiterEndIndex + 1)
        Pair(customDelimiter, numbers)
    } else {
        Pair(",|:", input)
    }
}

fun splitNumbers(input: String, delimiter: String): List<String> {
    return input.split(Regex(delimiter))
}