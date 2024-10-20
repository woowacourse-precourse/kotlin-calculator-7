package calculator
import camp.nextstep.edu.missionutils.Console

fun main() {
    // 사용자 입력
    println("값을 입력해주세요:")
    val input = Console.readLine() ?: ""

    // 값이 빈 문자열일 경우 0을 반환
    if (input.isBlank()) {
        println("결과: 0")
        return
    }

    // 구분자 선언
    val delimiters = listOf(",", ":")

    // 구분자를 이용한 문자열 스플릿
    val tokens = input.split(*delimiters.toTypedArray())

    // 문자열을 숫자로 변환하고 더하기
    val sum = tokens.map { it.trim().toIntOrNull() ?: 0 }.sum()

    // 결과값 출력
    println("결과: $sum")
}