package calculator

import calculator.constants.Message

object Validator {

    /**
     * 입력한 문자들이 양수인지 검증
     */
    fun validatePositiveNumber(number: String) = runCatching {
        number.toLong()
    }.map {
        if (it >= 0) true
        else throw IllegalArgumentException(Message.POSITIVE_NUMBER_ERROR)
    }.getOrElse {
        throw IllegalArgumentException(Message.INPUT_NUMBER_ERROR)
    }

    /**
     * 커스텀 구분자 검증
     */
    fun validateCustomSeparator(separator: Char) = runCatching {
        if (separator.isDigit()) {
            throw IllegalArgumentException(Message.INPUT_SEPARATOR_ERROR)
        }
        true
    }.getOrThrow()

    /**
     * 커스텀 구분자의 길이 검증
     */
    fun validateCustomSeparatorLength(separator: String) = runCatching {
        separator.single()
    }.map {
        true
    }.getOrElse {
        throw IllegalArgumentException(Message.INPUT_CUSTOM_SEPARATOR_LENGTH_ERROR)
    }
}