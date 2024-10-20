package calculator

class CalculatorController {
    private var delimiter = DEFAULT_REGEX

    fun run() {
        // user input
        val input = userInput()

        // custom delimiter

        // invalidate
        input.calculateInputValidate()

        // split
        val numbers: List<Int> = input.split(Regex("[$delimiter]"))
            .filter { it.isNotEmpty() }
            .map { it.toInt() }

        // sum operation
        calculatorOutput(numbers.sum())
    }

    private fun userInput(): String {
        println(USER_INPUT_MESSAGE)
        return readlnOrNull() ?: USER_BLANK_INPUT
    }

    private fun String.calculateInputValidate(customDelimiter: String? = null) {
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
