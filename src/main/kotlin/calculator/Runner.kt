package calculator

import camp.nextstep.edu.missionutils.Console

class Runner {
    private val numberExtractor = NumberExtractor()

    fun run() {
        println(INPUT_MESSAGE)
        var input = Console.readLine()

        if (isCustomSeparator(input)) {
            val separator = input.substring(2, input.indexOf(CUSTOM_DELIMITER_SUFFIX))
            numberExtractor.addSeparator(separator)
            input = input.substring(input.indexOf(CUSTOM_DELIMITER_SUFFIX) + 2)
        }
        val numbers = numberExtractor.extractNumbers(input)
        val result = longArraySum(numbers)

        print(createResultMsg(result))
    }

    private fun isCustomSeparator(input: String): Boolean {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX) && input.contains(CUSTOM_DELIMITER_SUFFIX)
    }

    companion object {
        const val INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요."
        const val CUSTOM_DELIMITER_PREFIX = "//"
        const val CUSTOM_DELIMITER_SUFFIX = "\\n"
        const val RESULT_MESSAGE = "결과 : "

        fun createResultMsg(num: Long): String {
            return "$RESULT_MESSAGE$num"
        }
    }
}
