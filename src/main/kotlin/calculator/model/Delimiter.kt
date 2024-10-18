package calculator.model

class Delimiter(
    private val input: String
) {
    private val delimiters: MutableList<String> = mutableListOf(",", ":")
    private val customDelimiterPattern: Regex = """//(.+?)\\n""".toRegex()

    init {
        val customDelimiters = findCustomDelimiter(input)
        isValidDelimiter(customDelimiters)
        delimiters.addAll(customDelimiters)
    }

    fun getDelimiters(): List<String> {
        return delimiters.toList()
    }

    private fun findCustomDelimiter(input: String): List<String> {
        return customDelimiterPattern.findAll(input).map { it.groupValues[1] }.toList()
    }

    private fun isValidDelimiter(customDelimiters: List<String>): Boolean {
        customDelimiters.forEach { delimiter ->

            if (delimiter.length != 1) {
                throw IllegalArgumentException(INVALID_SIZE_MESSAGE)
            }

            if (delimiter.all { it.isDigit() }) {
                throw IllegalArgumentException(INVALID_CHARACTER_MESSAGE)
            }
        }

        return true
    }

    companion object {
        const val INVALID_SIZE_MESSAGE = "유효하지 않은 크기"
        const val INVALID_CHARACTER_MESSAGE = "유효하지 않은 유형"
    }
}