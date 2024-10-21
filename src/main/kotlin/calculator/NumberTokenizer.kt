package calculator

import calculator.Constants.CUSTOM_DELIMITER_PREFIX
import calculator.Constants.CUSTOM_DELIMITER_SUFFIX
import java.math.BigDecimal

class NumberTokenizer {

    fun tokenize(input: String, delimiters: List<String>): List<BigDecimal> {
        val filteringInput = filterOutCustomDelimiters(input, delimiters)
        val inputTokens = splitByDelimiters(filteringInput, delimiters)
        val numberTokens = parseNumbers(inputTokens)
        validatePositiveNumbers(numberTokens)
        return numberTokens
    }

    private fun filterOutCustomDelimiters(input: String, delimiter: List<String>): String {
        val filteringInput = delimiter.fold(input) { acc, removeDelimiters ->
            acc.replace(CUSTOM_DELIMITER_PREFIX + removeDelimiters + CUSTOM_DELIMITER_SUFFIX, EMPTY_STRING)
        }
        return filteringInput
    }

    private fun splitByDelimiters(input: String, delimiters: List<String>) = delimiters.fold(input) { acc, delimiter ->
        acc.replace(delimiter, DELIMITER_UNIFIED)
    }.split(DELIMITER_UNIFIED)

    private fun parseNumbers(tokens: List<String>) = tokens.map { numberInput ->
        numberInput.toBigDecimal()
    }

    private fun validatePositiveNumbers(numbers: List<BigDecimal>) {
        numbers.forEach { number ->
            require(number >= NUMBER_MINIMUM_LIMIT.toBigDecimal())
        }
    }


    companion object {
        private const val DELIMITER_UNIFIED = " "
        private const val NUMBER_MINIMUM_LIMIT = 0
        private const val EMPTY_STRING = ""
    }
}