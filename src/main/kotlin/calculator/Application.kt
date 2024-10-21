package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("문자열을 입력해주세요.")
    val input = Console.readLine()
    checkValid(input)
}

private fun checkValid(inputText: String) {

    val (numbers, customDelimiters) = tokenizeString(inputText)
    if (numbers.isEmpty()) {
        return print(0)
    }

    val numberRegex = customDelimiters.joinToString("|") { "\\$it" } // 각 구분자를 이스케이프 처리

    val numberList = numbers.split(Regex(numberRegex))

    for (number in numberList) {

        if (number.toInt() < 0) { // 음수 체크 추가

            throw IllegalArgumentException("음수를 입력 할 수 없습니다.")
        }
    }
    println("결과 : " + addList(numberList))
}


private fun addList(numbers: List<String>): Int {
    var sum = 0
    for (number in numbers) {
        // 문자열을 정수로 변환하고, null인 경우는 무시
        val intValue = number.toIntOrNull()
        if (intValue != null) {
            sum += intValue
        }
    }
    return sum
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
        val operators = defaultDelimiters.filter { inputText.contains(it) } // 기본 구분자 중 입력에 포함된 것만 필터링
        val numbers = parts.last() // 마지막 부분을 숫자로

        Pair(numbers, operators) // 숫자와 연산자 반환
    }
}






