package calculator

import calculator.constants.Message

class Validator {

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