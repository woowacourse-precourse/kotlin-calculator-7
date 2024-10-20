package calculator

class CalculatorController {
    private var delimiter = DEFAULT_REGEX

    fun run() {
        // user input
        val input = userInput()

        // custom delimiter
        val calculationNumbers = parseCustomDelimiter(input)

        // invalidate
        calculationNumbers.calculateInputValidate()

        // split
        val numbers: List<Int> =
            calculationNumbers
                .split(Regex("[$delimiter]"))
                .filter { it.isNotEmpty() }
                .map { it.toInt() }

        // sum operation
        calculatorOutput(numbers.sum())
    }

    private fun parseCustomDelimiter(input: String): String {
        val pattern = Regex("""^//(.*)\\n(.*)$""")
        val matchResult = pattern.find(input)
        matchResult?.let {
            delimiter = it.groupValues[1]
            return it.groupValues[2]
        } ?: return input
    }

    private fun userInput(): String {
        println(USER_INPUT_MESSAGE)
        return readlnOrNull() ?: USER_BLANK_INPUT
    }

    private fun String.calculateInputValidate() {
        val pattern = Regex("""^\d+([$delimiter]\d+)*$""")
        pattern.isNotMatch(this)
    }

    private fun Regex.isNotMatch(userInput: String) {
        if (!this.matches(userInput)) {
            throw IllegalArgumentException()
        }
    }

    private fun calculatorOutput(sum: Int) {
        println(OUTPUT_PREFIX + sum)
    }

    companion object {
        const val USER_INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요."
        const val OUTPUT_PREFIX = "결과 : "

        const val USER_BLANK_INPUT = "0"
        const val DEFAULT_REGEX = ",:"
    }
}
