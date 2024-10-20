package calculator
import camp.nextstep.edu.missionutils.Console

fun main() {
    // 사용자 입력
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine() ?: ""

    // 값이 빈 문자열일 경우 0을 반환
    if (input.isBlank()) {
        println("결과: 0")
        return
    }

    // 구분자와 구분자를 제외한 문자열 추출
    val (delimiter, numbers) = getDelimiterAndNumbers(input)
    println(delimiter.toString())
    // 구분자를 이용한 문자열 스플릿
    val tokens = numbers.split(delimiter).map { it.trim() }
    println(tokens)

    // 문자열을 숫자로 변환하고 더하기
    val sum = tokens.map { it.toIntOrNull() ?: 0 }.sum()

    // 결과값 출력
    println("결과 : $sum")
}

fun getDelimiterAndNumbers(input: String): Pair<Regex, String> {
    return if (input.startsWith("//")) {
        // 커스텀 구분자 처리
        val delimiterEndIndex = input.lastIndexOf("\\n")
        if (delimiterEndIndex == -1) {
            throw IllegalArgumentException("잘못된 커스텀 구분자 형식입니다:")
        }

        val customDelimiter = input.substring(2, delimiterEndIndex)
        val numbers = input.substring(delimiterEndIndex + 2)
        Pair(Regex(customDelimiter), numbers)
    } else {
        Pair(Regex("[,:]"), input)
    }
}