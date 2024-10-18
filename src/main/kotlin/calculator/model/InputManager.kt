package calculator.model

class InputManager(
    private val delimiters: List<String>
) {

    fun removeCustomDelimiterDefinition(input: String): String {
        val regex = Regex("""//.\\n""")
        return regex.replace(input, "")
    }

    fun findAllNumbers(cleanedInput: String): List<Int> {
        return cleanedInput.split(*delimiters.toTypedArray()).toIntList()
    }

    private fun List<String>.toIntList(): List<Int> {
        if (this.isEmpty()) return emptyList()

        return this.map {
            it.toIntOrNull() ?: throw IllegalArgumentException(NON_NUMERIC_MESSAGE)
        }
    }

    fun isContainNegativeNumber(nums: List<Int>): Boolean {
        nums.forEach {
            if (it < 0) throw IllegalArgumentException(NEGATIVE_NUMBER_MESSAGE)
        }

        return true
    }

    companion object {
        const val NEGATIVE_NUMBER_MESSAGE = "지원하지 않는 피연산자 - 음수"
        const val NON_NUMERIC_MESSAGE = "지원하지 않는 피연산자 - 문자"
    }
}