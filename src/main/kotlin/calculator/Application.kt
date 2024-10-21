package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine() // 사용자 입력 받기
    try {
        val result = add(input) // 입력 문자열 덧셈 계산
        println("결과 : $result") // 결과 출력
    } catch (e: IllegalArgumentException) {
        // 잘못된 입력일 경우 프로그램이 조용히 종료되도록 함
        return
    }
}

fun add(input: String): Int {
    if (input.isBlank()) {
        return 0 // 빈 문자열의 경우 0 반환
    }

    // 사용자 정의 구분자 처리
    if (input.startsWith("//")) {
        val customDelimiterEnd = input.indexOf("\n") // 사용자 정의 구분자가 끝나는 위치 찾기
        if (customDelimiterEnd == -1) {
            return 0 // 줄바꿈이 없는 경우 빈 문자열로 처리하여 0 반환
        }
        val customDelimiter = input.substring(2, customDelimiterEnd) // 사용자 정의 구분자 추출
        val numbers = input.substring(customDelimiterEnd + 1) // 사용자 정의 구분자 이후의 숫자 추출
        return splitAndSum(numbers, "[,|:|${Regex.escape(customDelimiter)}]") // 사용자 정의 구분자 및 기본 구분자로 숫자 분리 후 합 계산
    } else {
        return splitAndSum(input) // 기본 구분자(쉼표, 콜론)로 숫자 분리 후 합 계산
    }
}

fun splitAndSum(input: String, delimiter: String = "[,|:]"): Int {
    // 입력 문자열을 구분자로 분리한 뒤 각 숫자를 더하는 함수
    if (input.isBlank()) {
        return 0
    }
    val numbers = input.split(Regex(delimiter)) // 사용자 정의 구분자 및 기본 구분자를 정규식으로 사용하여 분리
        .map {
            it.toIntOrNull() ?: throw IllegalArgumentException() // 숫자로 변환 불가능한 경우 예외 발생
        }
    return numbers.sum() // 숫자들의 합을 반환
}
