package calculator.util

object Validator {

    fun isValidNumber(input: String, delimiter: Array<String>): Boolean {
        val numbers = input.split(*delimiter).toList()

        numbers.forEach { it.toIntOrNull() ?: return false }
        return true
    }

}