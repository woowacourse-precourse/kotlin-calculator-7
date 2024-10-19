package calculator

class Validator {

    fun validatePositiveNumber(number: String): Boolean {
        if (number.toInt() >= 0) {
            return true
        } else {
            throw IllegalArgumentException("입력하신 숫자는 양수가 아닙니다.")
        }
    }
}