package calculator.validator

object InputValidator {
    fun validateInput(input: String) {
        require(isValidInputType(input)) { INVALID_INPUT }
        require(isAllPositive(input)) { IS_ANY_NEGATIVE }
    }

    fun getValidNumbers(input: String): List<Int> {
        val separators = setSeparators(input)
        val processedInput = getProcessedInput(input)
        if (processedInput.isEmpty())
            return listOf(0)
        return processedInput.split(*separators.toCharArray()).map { it.toInt() }
    }

    private fun isAllPositive(input: String): Boolean {
        val separators = setSeparators(input)
        val numbers = getValidNumbers(input)
        return numbers.all { it >= 0 }
    }

    // 커스텀 구분자 지정 공간 이후 문자열 반환
    private fun getProcessedInput(input: String): String {
        if (isCustomSeparator(input))
            return input.substring(5)
        return input
    }

    // 문자열이 유효한 형식인지 validate
    private fun isValidInputType(input: String): Boolean {
        val processedInput = getProcessedInput(input)
        if (processedInput.isEmpty()) return true

        val separators = setSeparators(input)
        try {
            processedInput.split(*separators.toCharArray()).map { it.toInt() }
        } catch (e: NumberFormatException) {
            return false
        }
        return true
    }

    private fun setSeparators(input: String): List<Char> {
        val separators = mutableSetOf(',', ':')
        if (isCustomSeparator(input))
            separators += getCustomSeparator(input)

        return separators.toList()
    }

    // 커스텀 구분자 사용하는지
    private fun isCustomSeparator(string: String): Boolean {
        val regex = Regex("^//.\\\\n")
        if (string.length >= 5)
            return regex.containsMatchIn(string)
        return false
    }

    private fun getCustomSeparator(string: String): Char = string[CUSTOM_SEPARATOR_IDX]

    private const val CUSTOM_SEPARATOR_IDX = 2

    private const val INVALID_INPUT = "유효하지 않은 형식의 문자열입니다."
    private const val IS_ANY_NEGATIVE = "음수가 포함되어 있습니다."
}