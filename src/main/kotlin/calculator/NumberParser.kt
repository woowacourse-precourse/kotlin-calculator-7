package calculator

import calculator.Constant
import calculator.Constant.EMPTY_TOKEN
import calculator.Constant.INVALID_NUMBER
import calculator.Constant.NEGATIVE_NUMBER
import calculator.Constant.NO_NUMBERS_INPUT

object NumberParser {

    /**
     * 분할된 문자열을 숫자로 변환
     * 숫자가 아닌 값이나 음수 포함 시 예외 발생
     */
    fun parseNumbers(tokens: List<String>): List<Int> {
        if (tokens.isEmpty()) {
            throw IllegalArgumentException(NO_NUMBERS_INPUT)
        }
        return tokens.map { token ->
            if (token.isEmpty()) {
                throw IllegalArgumentException(EMPTY_TOKEN)
            }
            val number = token.toIntOrNull()
                ?: throw IllegalArgumentException(INVALID_NUMBER + token)
            if (number < 0) {
                throw IllegalArgumentException(NEGATIVE_NUMBER + number)
            }
            number
        }
    }
}