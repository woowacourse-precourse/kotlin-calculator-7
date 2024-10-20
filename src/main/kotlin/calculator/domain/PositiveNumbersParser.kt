package calculator.domain

class PositiveNumbersParser {
    fun parse(userInput: String): List<Double> = try {
        var delimiters = DEFAULT_DELIMITERS
        var positiveNumbersPart = userInput

        if (userInput.startsWith(CUSTOM_DELIMITERS_START)) {
            val (customDelimiters, customDelimitersEndIndex) = getCustomDelimiters(userInput)

            delimiters += customDelimiters
            positiveNumbersPart = userInput.substring(customDelimitersEndIndex + 1)
        }

        positiveNumbersPart.split(*delimiters).map {
            require(!it.any { char -> char.isWhitespace() }) // toDouble은 자체적으로 trim을 하므로 공백있는지 체크
            it.toDouble().also { number -> require(number > 0) }
        }
    } catch (_: NumberFormatException) {
        throw IllegalArgumentException()
    }

    private fun getCustomDelimiters(userInput: String): CustomDelimitersResult {
        val customDelimitersEndIndex = userInput.indexOf(CUSTOM_DELIMITERS_END).also { require(it != -1) }

        val customDelimiters =
            userInput.substring(CUSTOM_DELIMITERS_START.length, customDelimitersEndIndex).toCharArray()

        return CustomDelimitersResult(
            customDelimiters = customDelimiters,
            customDelimitersEndIndex = customDelimitersEndIndex
        )
    }

    companion object {
        private val DEFAULT_DELIMITERS = charArrayOf(',', ':')
        private const val CUSTOM_DELIMITERS_START = "//"
        private const val CUSTOM_DELIMITERS_END = '\n'
    }
}