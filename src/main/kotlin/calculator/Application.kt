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

    val delimiters = arrayOf(",", ":") // 구분자 정의
    val numbers = input.split(*delimiters).map { it.toInt() } // 구분자로 숫자 분리

    return numbers.sum() // 더한 숫자 반환
}
