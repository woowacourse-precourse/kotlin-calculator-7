package calculator.util

object Validator {

    fun validNumber(number: String, delimiter: Array<String>) {
        if (isZero(number)) return

        val numbers = number.split(*delimiter).toList()
        numbers.forEach { it.toIntOrNull() ?: throw IllegalArgumentException() }
    }

    private fun isZero(input: String) = input.isEmpty()

}