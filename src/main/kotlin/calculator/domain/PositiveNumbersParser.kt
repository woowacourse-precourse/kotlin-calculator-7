package calculator.domain

class PositiveNumbersParser {
    fun parse(userInput: String): List<Double> = try {
        var delimiters = DEFAULT_DELIMITERS
        var positiveNumbersPart = userInput

        if (userInput.startsWith(CUSTOM_DELIMITERS_START)) {
            val (customDelimiters, customDelimitersEndIndex) = getCustomDelimiters(userInput)

            delimiters += customDelimiters
            positiveNumbersPart = userInput.substring(customDelimitersEndIndex + CUSTOM_DELIMITERS_END.length)
        }

        positiveNumbersPart.split(*delimiters).map {
            require(!it.any { char -> char.isWhitespace() }) // toDouble은 자체적으로 trim을 하므로 공백있는지 체크
            it.toDouble().also { number -> require(number > 0) }
        }
    } catch (_: NumberFormatException) {
        throw IllegalArgumentException()
    }

    private fun getCustomDelimiters(userInput: String): CustomDelimitersResult {
        val customDelimitersEndIndex = userInput.indexOf(CUSTOM_DELIMITERS_END).also { require(it.isFound()) }

        val customDelimiters =
            userInput.substring(CUSTOM_DELIMITERS_START.length, customDelimitersEndIndex).toCharArray()

        return CustomDelimitersResult(
            customDelimiters = customDelimiters,
            customDelimitersEndIndex = customDelimitersEndIndex
        )
    }

    private fun Int.isFound(): Boolean = this != -1

    companion object {
        private val DEFAULT_DELIMITERS = charArrayOf(',', ':')
        const val CUSTOM_DELIMITERS_START = "//"
        const val CUSTOM_DELIMITERS_END = "\\n"
    }
}