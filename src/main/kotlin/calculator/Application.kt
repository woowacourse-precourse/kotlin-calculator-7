package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine() ?: ""
    val result = add(input)
    println("결과 : $result")
}

fun add(input: String?): Int {
    if (input.isNullOrEmpty()) { // 빈 문자열 또는 null 입력할 경우 0 반환
        return 0
    }
    val numbers = parseNumbers(input)
    return numbers.sum()
}

fun parseNumbers(input: String): List<Int> {
    val delimiters = listOf(",", ":") // 쉼표와 콜론을 구분자로 설정
    val tokens = input.split(*delimiters.toTypedArray()) // 구분자를 기준으로 숫자 분리

    return tokens.map {
        val number = it
        if (number.isEmpty()) {
            0 // 빈 문자열이 있을 경우 0으로 처리
        } else {
            number.toInt() // 문자열을 숫자로 변환
        }
    }
}