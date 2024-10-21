package calculator

import calculator.constants.Message

class Validator {

    /**
     * 입력한 문자들이 양수인지 검증
     */
    fun validatePositiveNumber(number: String): Boolean {
        return try {
            if (number.toLong() >= 0) {
                true
            } else {
                throw IllegalArgumentException(Message.POSITIVE_NUMBER_ERROR)
            }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(Message.INPUT_NUMBER_ERROR)
        }
    }
}