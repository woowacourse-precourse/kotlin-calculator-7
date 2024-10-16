package calculator

fun main() {
    while (true) {
        val input = readln()
        val inputNumbers = splitInput(input)
    }
}


fun splitInput(input: String): List<String> {
    var delimiters = ",|;"
    var numbers = input
    if (input.startsWith("//")) {
        val inputParts = input.substring(2).split("\\n", limit = 2)
        val customDelimiter = inputParts[0]
        if (customDelimiter.isEmpty() || customDelimiter.contains("[0-9]".toRegex()) || inputParts.size < 2) {
            throw IllegalArgumentException("Invalid input: $input")
        }
        numbers = inputParts[1]
        delimiters += "|$customDelimiter"
    }
    return numbers.split(delimiters.toRegex())
}
