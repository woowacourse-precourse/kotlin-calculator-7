package calculator.util

object Validator {

    fun isValidNumber(input: String, delimiter: Array<String>): Boolean {
        if (isZero(input)) return true

        val numbers = input.split(*delimiter).toList()
        numbers.forEach { it.toIntOrNull() ?: return false }

        return true
    }

    private fun isZero(input: String) = input.isEmpty()

}