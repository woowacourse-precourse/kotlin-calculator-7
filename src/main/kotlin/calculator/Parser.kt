package calculator

class Parser {
    val validator = Validator()

    fun parseSeparator(input: String): List<String> {
        var userInput = input
        if (input.contains("\\n") and input.contains("//")) {
            val customSeparator = getCustomSeparator(input)
            userInput = userInput.substring(5)
            return userInput.split(",", ":", customSeparator)
                .filter { it.isNotEmpty() }
        } else {
            return userInput.split(",", ":")
                .filter { it.isNotEmpty() }
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

    fun getCustomSeparator(input: String) = input.split("//", "\\n").filter { it.isNotEmpty() }.first()
}