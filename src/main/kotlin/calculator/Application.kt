package calculator

fun main() {
    val input = readln()
    val inputNumbers = splitInput(input)
    val sum = addNumbers(inputNumbers)
    println("결과: $sum")
}


fun splitInput(input: String): List<String> {
    var delimiters = ",|;"
    var numbers = input
    if (input.startsWith("//")) {
        val inputParts = input.substring(2).split("\\n", limit = 2)
        val customDelimiter = inputParts[0]
        if (customDelimiter.isEmpty() || customDelimiter.contains("[0-9]".toRegex()) || inputParts.size < 2) {
            throw IllegalArgumentException("Invalid input")
        }
        numbers = inputParts[1]
        delimiters += "|$customDelimiter"
    }
    return numbers.split(delimiters.toRegex())
}


fun addNumbers(numbers: List<String>): Int {
    var sum = 0
    numbers.filter { it.isNotEmpty() }.forEach {
        val number = it.toIntOrNull()
        if (number == null || number < 0 || number > Int.MAX_VALUE - sum) {
            throw IllegalArgumentException("Invalid input")
        }
        sum += number
    }
    return sum
}
