package calculator

class Calculator(private val numbers: List<String>) {

    fun sumOfSplitNumbers(): Int = numbers
        .map { it.toIntOrNull() ?: throw IllegalArgumentException(ErrorType.INVALID_NON_DIGIT_INPUT.message) }
        .also { validateAllPositive(it) }
        .sum()

    private fun validateAllPositive(numbers: List<Int>) {
        if (numbers.any { it <= 0 })
            throw IllegalArgumentException(ErrorType.INVALID_NON_POSITIVE_INPUT.message)
    }
}