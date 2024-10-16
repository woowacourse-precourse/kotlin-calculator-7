package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine() // 입력 받기
    val result = calculateSum(input)
    println("결과 : $result")
}

fun calculateSum(input: String): Int { // 계산 함수
    if (input.isBlank()) { // 빈 문자열일 경우 0을 반환
        return 0
    }

    val delimiters = arrayOf(",", ":") // 기본 구분자 정의

    // 커스텀 구분자 처리
    val (numbersString, customDelimiter) = if (input.startsWith("//")) {
        val customDelimiter = input.substring(2, input.indexOf("\\n")) // "//"와 "\n" 사이의 구분자 추출
        val numbersString = input.substring(input.indexOf("\\n") + 2) // 숫자 문자열 부분 추출
        Pair(numbersString, customDelimiter)
    } else {
        Pair(input, null)
    }

    // 커스텀 구분자가 있을 경우 포함하여 split
    val numbers = if (customDelimiter != null) {
        numbersString.split(customDelimiter)
    } else {
        numbersString.split(*delimiters) // 기본 구분자일 경우
    }.map { it.toInt() } // 숫자로 변환

    return numbers.sum() // 더한 숫자 반환
}
