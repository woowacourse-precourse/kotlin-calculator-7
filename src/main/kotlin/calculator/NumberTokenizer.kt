package calculator

import java.math.BigDecimal

const val DELIMITER_COMMA = ","
const val DELIMITER_COLON = ":"
const val DELIMITER_UNIFIED = " "
const val NUMBER_MINIMUM_LIMIT = 0
const val CUSTOM_DELIMITER_PREFIX = "//"
const val CUSTOM_DELIMITER_SUFFIX = "\\n"
const val INDEX_NOT_FOUND = 1

class NumberTokenizer {

    private val delimiters = listOf(DELIMITER_COMMA, DELIMITER_COLON)

    fun tokenize(input: String): List<BigDecimal> {
        val customDelimiters = extractCustomDelimiters(input)
        val filteringInput = filterCustom(input, customDelimiters)
        val totalDelimiters = customDelimiters + delimiters
        return totalDelimiters.fold(filteringInput) { acc, delimiter ->
            acc.replace(delimiter, DELIMITER_UNIFIED)
        }.split(DELIMITER_UNIFIED).map { numberInput ->
            val number = numberInput.toBigDecimal()
            require(number >= NUMBER_MINIMUM_LIMIT.toBigDecimal())
            number
        }
    }

    fun extractCustomDelimiters(input: String): List<String> {
        val customDelimiters = mutableListOf<String>()
        val parts = input.split(CUSTOM_DELIMITER_SUFFIX)
        for (part in parts) {
            val delimiterStartIndex = part.indexOf(CUSTOM_DELIMITER_PREFIX)
            if (delimiterStartIndex == INDEX_NOT_FOUND) break
            val customDelimiter = part.substring(delimiterStartIndex)
            customDelimiters.add(customDelimiter.removeSuffix(CUSTOM_DELIMITER_PREFIX))
        }
        return customDelimiters
    }

    private fun filterCustom(input: String, customDelimiters: List<String>): String {
        val filteringInput = customDelimiters.fold(input) { acc, removeDelimiters ->
            acc.replace(CUSTOM_DELIMITER_PREFIX + removeDelimiters + CUSTOM_DELIMITER_SUFFIX, "")
        }
        return filteringInput
    }
}