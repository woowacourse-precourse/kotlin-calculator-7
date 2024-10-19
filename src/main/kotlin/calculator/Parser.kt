package calculator

class Parser {
    private val validator = Validator()

    private fun getCustomSeparator(input: String) = input.split("//", "\\n").first { it.isNotEmpty() }

    private fun getNumbers(input: String) = input.split("//", "\\n").last { it.isNotEmpty() }

    fun parseSeparator(input: String): List<String> {
        val numbers = getNumbers(input)
        if (input.contains("\\n") and input.contains("//")) {
            val customSeparator = getCustomSeparator(input)
            return numbers.split(",", ":", customSeparator)
        } else {
            return numbers.split(",", ":")
        }
    }

    fun parseNumber(list: List<String>): MutableList<Int> {
        val numbers = mutableListOf<Int>()
        list.forEach {
            if (validator.validatePositiveNumber(it)) {
                numbers.add(it.toInt())
            }
        }
        return numbers
    }
}