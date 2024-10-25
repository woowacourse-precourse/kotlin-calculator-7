package calculator.util

object Validator {
    fun areNumbersValid(numbers: List<Double>): Boolean {
        return numbers.areAllPositive
    }

    private val List<Double>.areAllPositive: Boolean
        get() = all { it > 0 }
}