package calculator

class Parser {
    private val validator = Validator()

    private fun getSeparators(input: String): List<String> {
        val defalutSeparators = listOf(",", ":")
        val regex = """^//(.+)\\n(.*)""".toRegex()
        val matchResult = regex.find(input)

        return if (matchResult != null) {
            val customSeparator = matchResult.groupValues[1]
            defalutSeparators + customSeparator
        } else {
            defalutSeparators
        }
    }

    private fun getNumbers(input: String, separator: List<String>): String {
        return if (separator.size > 2) {
            input.substringAfter("\\n")
        } else {
            input
        }
    }

    fun parseSeparator(input: String): List<String> {
        val separators = getSeparators(input)
        val numbers = getNumbers(input, separators)

        return numbers.split(*separators.toTypedArray())
    }

    fun parseNumber(list: List<String>): List<Long> {
        val numbers = mutableListOf<Long>()
        list.forEach {
            if (validator.validatePositiveNumber(it)) {
                numbers.add(it.toLong())
            }
        }
        return numbers
    }
}