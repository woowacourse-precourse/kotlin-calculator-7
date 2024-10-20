package calculator

class Separator {

    fun checkCustomSeparator(inputString: String): CalculatorType {
        return if (CUSTOM_PATTERN.matches(inputString)) {
            CalculatorType.CUSTOM
        } else {
            CalculatorType.STANDARD
        }
    }

    fun splitStandardSeparator(inputString: String): List<String> {
        val splitResult = inputString.split(DELIMITER_COMMA, DELIMITER_COLON)

        return splitResult
    }

    fun splitCustomSeparator(inputString: String): List<String> {
        // TODO 커스텀 구분자 분리 구현

        return emptyList()
    }

    companion object {
        private const val DELIMITER_COMMA = ","
        private const val DELIMITER_COLON = ":"

        private const val CUSTOM_DELIMITER_REGEX = """^//.\\n.*$"""
        val CUSTOM_PATTERN: Regex = Regex(CUSTOM_DELIMITER_REGEX)
    }
}