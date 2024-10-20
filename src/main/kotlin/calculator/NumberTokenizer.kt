package calculator

import java.math.BigDecimal

const val DELIMITER_COMMA = ","
const val DELIMITER_COLON = ":"
const val DELIMITER_UNIFIED = " "
const val NUMBER_MINIMUM_LIMIT = 0
const val CUSTOM_DELIMITER_PREFIX = "//"
const val CUSTOM_DELIMITER_SUFFIX = "\\n"
const val INDEX_NOT_FOUND = -1

class NumberTokenizer {

    private val delimiters = listOf(DELIMITER_COMMA, DELIMITER_COLON)

    fun tokenize(input: String): List<BigDecimal> {
        val customDelimiters = extractCustomDelimiters(input)
        val filteringInput = filterCustom(input, customDelimiters)
        val totalDelimiters = customDelimiters + delimiters
        val inputTokens = splitByDelimiters(filteringInput, totalDelimiters)
        val numberTokens = parseNumbers(inputTokens)
        validateNumbers(numberTokens)
        return numberTokens
    }

    private fun splitByDelimiters(input: String, delimiters: List<String>) = delimiters.fold(input) { acc, delimiter ->
        acc.replace(delimiter, DELIMITER_UNIFIED)
    }.split(DELIMITER_UNIFIED)

    private fun parseNumbers(tokens: List<String>) = tokens.map { numberInput ->
        numberInput.toBigDecimal()
    }

    private fun validateNumbers(numbers: List<BigDecimal>) {
        numbers.forEach { number ->
            require(number >= NUMBER_MINIMUM_LIMIT.toBigDecimal())
        }
    }


    fun extractCustomDelimiters(input: String): List<String> {
        val customDelimiters = mutableListOf<String>()
        val parts = input.split(CUSTOM_DELIMITER_SUFFIX)
        for (part in parts) {
            val delimiterPrefixIndex = part.indexOf(CUSTOM_DELIMITER_PREFIX)
            if (delimiterPrefixIndex == INDEX_NOT_FOUND) break
            customDelimiters.add(extractDelimiter(part, delimiterPrefixIndex))
        }
        return customDelimiters
    }

    private fun extractDelimiter(part: String, prefixIndex: Int) = part.substring(prefixIndex).removePrefix(
        CUSTOM_DELIMITER_PREFIX
    )

    private fun filterCustom(input: String, customDelimiters: List<String>): String {
        val filteringInput = customDelimiters.fold(input) { acc, removeDelimiters ->
            acc.replace(CUSTOM_DELIMITER_PREFIX + removeDelimiters + CUSTOM_DELIMITER_SUFFIX, "")
        }
        return filteringInput
    }
}