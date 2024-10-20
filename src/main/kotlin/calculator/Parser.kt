package calculator

class Parser(private val input: String) {
    private var hasCustomDelimiter = false
    private val delimiters = mutableListOf(DEFAULT_DELIMITER_COMMA, DEFAULT_DELIMITER_COLON)

    private fun findCustomDelimiter(): Boolean {
        val inputPrefix = input.take(CUSTOM_DELIMITER_FORMAT_LEN)
        val customDelimiterPattern = CUSTOM_DELIMITER_FORMAT_REGEX.toRegex()
        val isMatch = customDelimiterPattern.matches(inputPrefix)
        return isMatch
    }

    private fun updatePropertiesOrNone() {
        if (findCustomDelimiter()) {
            hasCustomDelimiter = true
            delimiters.add(input[CUSTOM_DELIMITER_INDEX])
        }
    }

    fun getParsingList(): List<Long> {
        updatePropertiesOrNone()
        val inputWithoutPrefix = if (hasCustomDelimiter) input.substring(CUSTOM_DELIMITER_FORMAT_LEN) else input
        val splitRegex = "[${delimiters.joinToString("")}]".toRegex()
        val parsingList = inputWithoutPrefix.split(splitRegex)
        return parsingList.map { parsingStr -> checkValidAndConvertToLong(parsingStr) }
    }

    private fun checkValidAndConvertToLong(str: String): Long {
        if (str == "") return 0
        try {
            if (str.length > MAX_NUMBER_LENGTH) throw IllegalArgumentException()
            if (str.toLong() < 0) throw IllegalArgumentException()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException()
        }
        return str.toLong()
    }
}

private const val DEFAULT_DELIMITER_COMMA = ','
private const val DEFAULT_DELIMITER_COLON = ':'

private const val CUSTOM_DELIMITER_FORMAT_LEN = 5
private const val CUSTOM_DELIMITER_INDEX = 2
private const val CUSTOM_DELIMITER_FORMAT_REGEX = """//([^\d\s])\\n"""

private const val MAX_NUMBER_LENGTH = 15