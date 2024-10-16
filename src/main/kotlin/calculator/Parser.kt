package calculator

class Parser {

    fun parseSeparator(input: String): List<String> {
        val numbers = input.split(",", ":")
        return numbers
    }
}