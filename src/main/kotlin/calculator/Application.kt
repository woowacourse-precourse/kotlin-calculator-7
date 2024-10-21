package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // 사용자 입력
    println("덧셈할 문자열을 입력해 주세요.")
    val userInput = Console.readLine() ?: ""

    // 입력이 비어있으면 0 출력
    if (userInput.isBlank()) {
        println("결과: 0")
        return
    }
    // 총합 계산 및 출력
    try {
        val totalSum = calculateSum(userInput)
        println("결과: $totalSum")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    } finally {
        Console.close()
    }
}
// 총합계산
fun calculateSum(input: String): Int {
    val numbers = extractNumbers(input)
    return numbers.sum()
}
// 숫자추출
fun extractNumbers(input: String): List<Int> {
    val numberList: List<String>

    // 유효한 커스텀 구분자를 추출하고 반환하는 함수
    fun getCustomDelimiter(input: String): Pair<String, String> {
        if (input[3] == '\\' && input[4] == 'n') {
            val customDelimiter = input.substring(2, 3)
            val numberSegment = input.substring(5)

            if (customDelimiter.all { it !in '0'..'9' }) {
                return Pair(customDelimiter, numberSegment)
            } else {
                throw IllegalArgumentException("유효하지 않은 구분자입니다.")
            }
        }
        throw IllegalArgumentException("올바른 커스텀 구분자가 없습니다.")
}
