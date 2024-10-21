package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()  // 사용자로부터 입력받음
    try {
        val result = add(input)
        println("결과 : $result")
    } catch (e: IllegalArgumentException) {
        println("잘못된 입력입니다: ${e.message}")
    }
}

fun add(input: String?): Int {
    if (input.isNullOrEmpty()) return 0  // 입력이 빈 문자열일 경우 0 반환

    try {
        if (input.startsWith("//")) {
            // 커스텀 구분자 처리
            val parts = input.split("\n", limit = 2)
            if (parts.size < 2 || parts[1].isEmpty()) {
                throw IllegalArgumentException("잘못된 입력입니다.")
            }
            val customDelimiter = parts[0].substring(2)  // 커스텀 구분자 추출
            return parts[1].split(customDelimiter)  // 커스텀 구분자로 숫자 분리
                .map { it.toInt() }
                .checkForNegativeNumbers()
                .sum()
        } else {
            // 쉼표와 콜론을 구분자로 처리
            val delimiters = "[,:]".toRegex()
            return input.split(delimiters)
                .map { it.toInt() }
                .checkForNegativeNumbers()
                .sum()
        }
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("잘못된 입력입니다.")
    }
}

// 음수가 포함된 경우 예외를 던지는 함수
fun List<Int>.checkForNegativeNumbers(): List<Int> {
    val negativeNumbers = this.filter { it < 0 }
    if (negativeNumbers.isNotEmpty()) {
        throw IllegalArgumentException("음수는 허용되지 않습니다: ${negativeNumbers.joinToString(", ")}")
    }
    return this
}
