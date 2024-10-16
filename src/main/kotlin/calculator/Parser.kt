package calculator

class Parser {

    fun parseSeparator(input: String): List<String> {
        val numbers = input.split(",", ":")
        return numbers
    }

    fun parseNumber(list: List<String>): MutableList<Int> {
        val numbers = mutableListOf<Int>()
        list.forEach {
            numbers.add(it.toInt())
        }
        return numbers
    }

    fun parseCustomSeparator(input: String): String {
        val userInput = input.split("//", "\\n")
            .filter { it.isNotEmpty() }
        return userInput[0]
    }
}