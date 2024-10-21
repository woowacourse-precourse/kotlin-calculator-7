package calculator

import calculator.Constants.CUSTOM_DELIMITER_PREFIX
import calculator.Constants.CUSTOM_DELIMITER_SUFFIX

class Delimiter {

    private val delimiters = listOf(DELIMITER_COMMA, DELIMITER_COLON)

    fun getDelimiters(input: String) = delimiters + extractCustomDelimiters(input)

    private fun extractCustomDelimiters(input: String): List<String> {
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

    companion object {
        private const val DELIMITER_COMMA = ","
        private const val DELIMITER_COLON = ":"
        private const val INDEX_NOT_FOUND = -1
    }
}