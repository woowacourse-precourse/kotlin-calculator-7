package calculator

import camp.nextstep.edu.missionutils.Console

fun main(args: Array<String>) {
    // 사용자로부터 입력값 받기
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()

    // 예외 처리와 결과 출력
    try {
        val result = add(input)
        println("결과 : $result")
    } catch (e: IllegalArgumentException) {
        println("잘못된 입력입니다: ${e.message}")
    }
}

// 구분자를 구분하고, 숫자들을 모아서 더한 값을 출력하는 함수
fun add(input: String): Int {
    // 빈 문자열 처리
    if (input.isEmpty()) return 0

    // 커스텀 구분자 또는 기본 구분자 설정 및 숫자 추출
    val (delimiters, numbers) = findCustomDelimiter(input) ?: Pair("[,:]".toRegex(), input)

    // 구분자를 사용하여 숫자를 분리하고 합산
    return numbers.split(delimiters).mapNotNull { it.trim().toIntOrNull() } // 공백 제거 후 숫자로 변환 가능한 경우만 처리
        .sum() // 숫자 합산
}

// 커스텀 구분자 찾는 함수
fun findCustomDelimiter(input: String): Pair<Regex, String>? {
    val regex = Regex("//(.)\\\\n(.*)")
    val matchResult = regex.find(input)

    return matchResult?.let {
        val customDelimiter = Regex(Regex.escape(it.groupValues[1])) // 커스텀 구분자
        val numbers = it.groupValues[2] // 숫자 부분
        Pair(customDelimiter, numbers)
    }
}