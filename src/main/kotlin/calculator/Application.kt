package calculator

import java.lang.IllegalArgumentException

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = readLine() ?: ""

    try {
        val result = add(input)
        println("결과 : $result")
    } catch (e: IllegalArgumentException) {
        println("${e.message}")
    }
}

fun add(input: String): Int {
    // 기능1. 빈 문자열 입력 처리
    if (input.isEmpty()) {
        return 0
    }

    // 기능2. 기본구분자(쉼표 또는 콜론)를 구분자로 가지는 문자열 덧셈
    var delimiters = "[,:]"
    var numbers = input

    // 기능3. 커스텀 구분자 지정
    if (input.startsWith("//")) {
        val customDelimiterPattern = Regex("//(.)\\\\n(.*)")
        val matchResult = customDelimiterPattern.find(input)

        if (matchResult != null) {
            val customDelimiter = matchResult.groupValues[1] // 커스텀 구분자
            delimiters = delimiters + "|${Regex.escape(customDelimiter)}" // 기본 구분자와 커스텀 구분자를 함께 사용
            numbers = matchResult.groupValues[2] // 숫자 부분
        } else {
            throw IllegalArgumentException("올바른 구분자가 입력되지 않았습니다.")
        }
    }

    //구분자를 사용하여 숫자 분리
    val splitNumbers = numbers.split(Regex(delimiters))

    // 기능4. 숫자 변환 및 예외 처리(음수, 숫자가 아닌 값)
    val validNumbers = splitNumbers.map {
        val number = it.toIntOrNull() ?: throw IllegalArgumentException("올바른 숫자가 입력되지 않았습니다.")
        if (number < 0) throw IllegalArgumentException("음수는 허용되지 않습니다.")
        number
    }

    return validNumbers.sum()
}
