package calculator

class Separator {
    private val errorChecker: ErrorChecker = ErrorChecker()

    fun checkCustomSeparator(inputString: String): CalculatorType {
        return if (CUSTOM_PATTERN.matches(inputString)) {
            CalculatorType.CUSTOM
        } else {
            CalculatorType.STANDARD
        }
    }

    fun splitStandardSeparator(inputString: String): List<String> {
        val splitResult = inputString.split(DELIMITER_COMMA, DELIMITER_COLON)
        errorChecker.checkErrorInSeparator(splitResult)

        return splitResult
    }

    fun splitCustomSeparator(inputString: String): List<String> {
        val delimiter = inputString[DELIMITER_INDEX]

        val index = inputString.indexOf(DELIMITER_INDEX_REGEX)
        errorChecker.checkDelimiterNotExist(index)

        val splitResult = inputString.substring(CUSTOM_NUMBER_START_INDEX).split(delimiter)
        errorChecker.checkErrorInSeparator(splitResult)

        return splitResult
    }

    companion object {
        private const val DELIMITER_COMMA = ","
        private const val DELIMITER_COLON = ":"
        private const val DELIMITER_INDEX = 2
        private const val CUSTOM_NUMBER_START_INDEX = 5

        private const val CUSTOM_DELIMITER_REGEX = """^//.*\\n.*$"""
        val CUSTOM_PATTERN: Regex = Regex(CUSTOM_DELIMITER_REGEX)
        private const val DELIMITER_INDEX_REGEX = "\\n"
    }
}