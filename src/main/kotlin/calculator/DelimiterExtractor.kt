package calculator

object DelimiterExtractor {

    fun extractDelimiters(input: String): Pair<List<String>, String> {
        return if (input.startsWith(Constant.CUSTOM_DELIMITER_PREFIX)) {
            val delimiterEndIndex = input.indexOf(Constant.CUSTOM_DELIMITER_SUFFIX)
            if (delimiterEndIndex == -1) {
                throw IllegalArgumentException(Constant.CUSTOM_DELIMITER_NEWLINE_MISSING)
            }
            val delimiterPart = input.substring(2, delimiterEndIndex)
            if (delimiterPart.isEmpty()) {
                throw IllegalArgumentException(Constant.CUSTOM_DELIMITER_EMPTY)
            }
            val customDelimiter = listOf(delimiterPart)
            val numbersString = input.substring(delimiterEndIndex + 1)
            Pair(customDelimiter, numbersString)
        } else {
            val defaultDelimiters = listOf(Constant.DEFAULT_DELIMITER_COMMA, Constant.DEFAULT_DELIMITER_COLON)
            Pair(defaultDelimiters, input)
        }
    }

}