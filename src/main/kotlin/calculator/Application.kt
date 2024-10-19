package calculator

import camp.nextstep.edu.missionutils.Console

fun main(args: Array<String>) {
    // 사용자로부터 입력값 받기
    val input = Console.readLine()

    // try-catch를 이용해서 예외 처리하기
    try {
        val result = add(input)
        println("결과 : $result")
    } catch (e: IllegalArgumentException) {
        println("잘못된 입력입니다: ${e.message}")
    }
}

// 구분자를 구분하고, 숫자들을 모아서 더한 값을 출력하는 함수
fun add(input: String): Int {
    // 빈 문자열 입력 시 0 출력 기능 구현
    if(input.isEmpty()) return 0

    // 빈 문자열 이외의 처리 기능 구현 전
    throw IllegalArgumentException("빈 문자열 이외의 입력 처리 기능이 아직 구현되지 않았습니다.")
}