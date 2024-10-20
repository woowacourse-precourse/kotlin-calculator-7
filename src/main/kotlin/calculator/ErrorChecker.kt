package calculator

class ErrorChecker {

    fun checkErrorInSeparator(splitResult: List<String>) {
        splitResult.forEach { item ->
            when {
                item.startsWith(ZERO) -> {
                    throw IllegalArgumentException(ErrorType.NUMBER_START_ZERO_INPUT_ERROR.errorMessage)
                }
                item.startsWith(BLANK) || item.endsWith(BLANK) -> {
                    throw IllegalArgumentException(ErrorType.NUMBER_INCLUDE_BLANK_INPUT_ERROR.errorMessage)
                }
                item.startsWith(PLUS) || item.startsWith(MINUS) -> {
                    throw IllegalArgumentException(ErrorType.WRONG_NUMBER_INPUT_ERROR.errorMessage)
                }
                item.toIntOrNull() != null -> Unit
                else -> {
                    throw IllegalArgumentException(ErrorType.WRONG_DELIMITER_INPUT_ERROR.errorMessage)
                }
            }
        }
    }

    fun checkDelimiterNotExist(index: Int) {
        when {
            index == DELIMITER_NOT_EXIST_CONDITION -> throw IllegalArgumentException(ErrorType.NO_EXIST_DELIMITER_INPUT_ERROR.errorMessage)
            index >= DELIMITER_LONGER_TWO_CONDITION -> throw IllegalArgumentException(ErrorType.DELIMITER_CAN_NOT_LONGER_TWO.errorMessage)
        }
    }

    companion object {
        private const val ZERO = "0"
        private const val BLANK = ' '
        private const val PLUS = "+"
        private const val MINUS = "-"

        private const val DELIMITER_NOT_EXIST_CONDITION = 2
        private const val DELIMITER_LONGER_TWO_CONDITION = 4
    }
}