package calculator.domain

class Calculator {
    fun add(input: String): Int {
        if (input.isBlank()) return 0

        val (delimiter, numbers) = parseInput(input)
        val tokens = splitNumbers(numbers, delimiter)

        return tokens.sumOf { it.toIntOrNull() ?: throw IllegalArgumentException("Invalid number") }
    }

    private fun parseInput(input: String): Pair<String, String> {
        return "[,:]" to input
    }

    private fun splitNumbers(numbers: String, delimiter: String): List<String> {
        val regex = delimiter.toRegex()
        return numbers.split(regex)
    }
}