package calculator

class Separator {

    fun splitSeparator(inputString: String): List<String> {
        val splitResult = inputString.split(DELIMITER_COMMA, DELIMITER_COLON)

        return splitResult
    }

    companion object {
        private const val DELIMITER_COMMA = ","
        private const val DELIMITER_COLON = ":"
    }
}