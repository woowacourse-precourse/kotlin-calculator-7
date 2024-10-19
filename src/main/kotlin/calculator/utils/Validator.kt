package calculator.utils

object Validator {

    fun validateNumbers(numbers: List<Int>) {
        for (idx in numbers.indices) {
            require(numbers[idx] > 0)
        }
    }
}