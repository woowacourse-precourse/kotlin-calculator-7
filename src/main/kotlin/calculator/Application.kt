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
        if ( input.indexOf("\\n") == -1)  {
            throw IllegalArgumentException() // 구분자 정의 없이 잘못된 형식일 경우 예외 처리
        }
        val numbersString = input.substring(input.indexOf("\\n") + 2) // 숫자 문자열 부분 추출
        Pair(numbersString, customDelimiter)
    } else {
        Pair(input, null) // 커스텀 구분자가 없으면 기본 구분자 사용
    }

    // 숫자 split
    val numbers = try {
        if (customDelimiter != null) {
            numbersString.split(customDelimiter) // 커스텀 구분자일 경우
        } else {
            numbersString.split(*delimiters) // 기본 구분자일 경우
        }.map {
            val number = it.toIntOrNull() ?: throw IllegalArgumentException() // 숫자가 아닌 값이 있을 경우 예외 처리
            if (number < 0) {
                throw IllegalArgumentException() // 음수가 있을 경우 예외 처리
            }
            number
        }
    } catch (e: Exception) {
        throw IllegalArgumentException()
    }

    return numbers.sum() // 더한 숫자 반환
}
