package calculator

import camp.nextstep.edu.missionutils.Console // 입력할 때 활용

const val PROMPT_INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요."
const val PROMPT_OUTPUT_MESSAGE = "결과 : "

fun main() {
    val inputHandler = InputHandler()
    val input = inputHandler.readInput()

    val result = if (input.isEmpty()) {
        throw IllegalArgumentException(ErrorType.INVALID_EMPTY_INPUT.message)
    } else {
        val splitNumberList = SeparatorHandler(input).getSplitNumberList()
        Calculator(splitNumberList).sumOfSplitNumbers()
    }
    OutputHandler().printOutput(result)
}

class InputHandler {
    fun readInput(): String {
        println(PROMPT_INPUT_MESSAGE)
        return Console.readLine()
    }
}

class OutputHandler {
    fun printOutput(output: Int) = println(PROMPT_OUTPUT_MESSAGE + output)
}
