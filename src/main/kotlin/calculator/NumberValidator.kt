package calculator

class NumberValidator {
    fun sumValidNumbers(numberList: List<String>): Int {
        val validNumber = numberList.sumOf { convertAndValidateNumber(it) }
        return validNumber
    }

    private fun convertAndValidateNumber(number: String): Int {
        val convertedNumber = convertToInt(number)
        validateNegativeNumber(convertedNumber)
        return convertedNumber
    }

    private fun convertToInt(number: String): Int {
        return number.toIntOrNull() ?: throw IllegalArgumentException("$NEGATIVE_NUMBER_ERROR $number")
    }

    private fun validateNegativeNumber(number: Int) {
        if (number < 0) {
            throw IllegalArgumentException(NEGATIVE_NUMBER_ERROR)
        }
    }

    companion object {
        private const val NEGATIVE_NUMBER_ERROR = "음수는 입력할 수 없습니다 "
    }
}