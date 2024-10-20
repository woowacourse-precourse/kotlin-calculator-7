package calculator.model

class InputParser(
    private val delimiters: List<String>
) {

    fun removeDelimiterDefinition(input: String): String {
        val regex = Regex("""//.\\n""")
        return regex.replace(input, "")
    }

    fun extractNumbers(cleanedInput: String): List<Int> {
        if (cleanedInput.isEmpty()) return emptyList()

        return cleanedInput.split(*delimiters.toTypedArray()).toIntList()
    }

    private fun List<String>.toIntList(): List<Int> = this.map {
        it.toIntOrNull() ?: throw IllegalArgumentException(INVALID_NUMBER_MESSAGE)
    }

    fun containNegativeNumber(nums: List<Int>): Boolean {
        nums.forEach {
            if (it < 0) throw IllegalArgumentException(NEGATIVE_NUMBER_MESSAGE)
        }

        return true
    }

    companion object {
        const val NEGATIVE_NUMBER_MESSAGE = "지원하지 않는 피연산자 - 음수"
        const val INVALID_NUMBER_MESSAGE = "지원하지 않는 피연산자 - 문자"
    }
}
