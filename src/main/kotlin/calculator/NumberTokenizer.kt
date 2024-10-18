package calculator

import java.math.BigDecimal

class NumberTokenizer {

    private val delimiters = listOf(",", ":")

    fun tokenize(input: String): List<BigDecimal> {
        val customDelimiters = extractCustomDelimiters(input)
        val filteringInput = filterCustom(input, customDelimiters)
        val totalDelimiters = customDelimiters + delimiters
        return totalDelimiters.fold(filteringInput) { acc, delimiter ->
            acc.replace(delimiter, " ")
        }.split(" ").map { numberInput ->
            val number = numberInput.toBigDecimal()
            require(number >= 0.toBigDecimal())
            number
        }
    }

    fun extractCustomDelimiters(input: String): List<String> {
        val customDelimiters = mutableListOf<String>()
        val parts = input.split("\\n")
        for (part in parts) {
            val delimiterStartIndex = part.indexOf("//")
            if (delimiterStartIndex == -1) break
            val customDelimiter = part.substring(delimiterStartIndex + 2)
            customDelimiters.add(customDelimiter)
        }
        return customDelimiters
    }

    private fun filterCustom(input: String, customDelimiters: List<String>): String {
        val filteringInput = customDelimiters.fold(input) { acc, removeDelimiters ->
            acc.replace("//$removeDelimiters\\n", "")
        }
        return filteringInput
    }
}