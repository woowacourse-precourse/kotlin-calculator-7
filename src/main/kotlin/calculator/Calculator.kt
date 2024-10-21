package calculator

import java.math.BigDecimal

class Calculator(private val delimiterExtractor: DelimiterExtractor) {
    //파싱한 배열의 합을 구하는 함수
    fun add(input: String): BigDecimal {
        //입력값이 비어있는 경우 0을 반환
        if (input.isBlank()) return BigDecimal.ZERO

        val numbers = parseNumbers(input)
        return numbers.sumOf { it }
    }
    //구분자로 문자열 파싱하는 함수
    private fun parseNumbers(input: String): List<BigDecimal> {

        val (delimiter, numbersString) = delimiterExtractor.extract(input)
        val numbers = numbersString.split(Regex(delimiter)).map {
            // 숫자로된 문자열로 나누어지지 않을 시 예외처리
            it.toBigDecimalOrNull() ?: throw IllegalArgumentException("잘못된 형식으로 숫자 분류가 실패되었습니다.")
        }

        //숫자가 음수인 경우 예외처리
        if (numbers.any { it < BigDecimal.ZERO }) {
            throw IllegalArgumentException("양수를 입력해주세요.")
        }
        return numbers
    }
}
