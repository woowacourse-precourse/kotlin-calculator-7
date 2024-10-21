package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("문자열을 입력해주세요.")
    val input = Console.readLine()

    try {
        checkValid(input)

    } catch (e: IllegalArgumentException) {
        println(e.message) // 예외 메시지를 출력
    }
}



private fun tokenizeString(inputText: String): Pair<String, List<String>> {
    return if (inputText.startsWith("//")) {
        val customDelimiterEndIndex = inputText.indexOf("\\n")
        val customDelimiter = inputText.substring(2, customDelimiterEndIndex)
        val inputNumber = inputText.substring(customDelimiterEndIndex + 2)
        Pair(inputNumber, listOf(customDelimiter))
    } else {
        // 기본 구분자 설정
        val defaultDelimiters = listOf(",", ":")
        // 마지막 \n을 기준으로 나누기
        val parts = inputText.split("\n")
        val operators = parts.dropLast(1).joinToString("") // 마지막 \n 앞의 모든 부분을 연산자로
        val numbers = parts.last() // 마지막 부분을 숫자로
        Pair(numbers, defaultDelimiters + operators) // 숫자와 기본 구분자 + 연산자 반환
    }
}






