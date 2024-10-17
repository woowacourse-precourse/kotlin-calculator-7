package calculator.util

import java.math.BigInteger

object Validator {

    fun validNumber(number: String, delimiter: Array<String>) {
        if (isZero(number)) return

        val numbers = number.split(*delimiter).filter { it != "" }.map { it }.toTypedArray()
        numbers.forEach {
            it.toBigIntegerOrNull() ?: throw IllegalArgumentException(
                String.format(Constant.ERROR_MESSAGE, number, delimiter.joinToString(""))
            )
        }
        if (hasNegativeNumberOrZero(numbers)) throw IllegalArgumentException(
            String.format(Constant.ERROR_MESSAGE, number, delimiter.joinToString(""))
        )
    }

    private fun isZero(input: String) = input.isEmpty()

    private fun hasNegativeNumberOrZero(numbers: Array<String>): Boolean {
        return numbers.any { it.toBigInteger() <= BigInteger.ZERO }
    }

}