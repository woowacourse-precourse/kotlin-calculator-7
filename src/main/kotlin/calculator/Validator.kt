package calculator

class Validator {

    fun validatePositiveNumber(number: String): Boolean {
        return try {
            if (number.toLong() >= 0) {
                true
            } else {
                throw IllegalArgumentException("입력하신 숫자는 양수가 아닙니다.")
            }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("유효한 숫자를 입력해주세요.")
        }
    }
}