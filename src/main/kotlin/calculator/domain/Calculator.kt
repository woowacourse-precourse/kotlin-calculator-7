package calculator.domain

class Calculator {
    fun add(input: String): Int {
        if (input.isBlank()) return 0

        val (delimiter, numbers) = parseInput(input)
        val tokens = splitNumbers(numbers, delimiter)

        return tokens.sumOf { token ->
            val number = token.toIntOrNull() ?: throw IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.")
            if (number < 0) {
                throw IllegalArgumentException("음수는 입력할 수 없습니다.")
            }
            number
        }
    }

    private fun parseInput(input: String): Pair<String, String> {
        return if (input.startsWith("//")) {
            val delimiterAndNumbers = input.split("\\n", limit = 2)
            val customDelimiter = delimiterAndNumbers[0].removePrefix("//")
            "[,:$customDelimiter]" to delimiterAndNumbers[1]
        } else {
            "[,:]" to input
        }
    }

    private fun splitNumbers(numbers: String, delimiter: String): List<String> {
        val regex = delimiter.toRegex()
        return numbers.split(regex)
    }
}