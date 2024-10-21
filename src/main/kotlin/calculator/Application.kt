package calculator

import camp.nextstep.edu.missionutils.Console // 입력할 때 활용

const val PROMPT_INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요."
const val PROMPT_OUTPUT_MESSAGE = "결과 : "

fun main() {
    println(PROMPT_INPUT_MESSAGE)

    val input = Console.readLine()
    val inputHandler = InputHandler()
    val input = inputHandler.readInput()

    if (input.isEmpty()) {
        printOutput(0)
        return
    }

    val splitNumberList = SeparatorHandler(input).getSplitNumberList()
    val result = Calculator(splitNumberList).sumOfSplitNumbers()
    printOutput(result)
}

fun printOutput(output: Int) = println(PROMPT_OUTPUT_MESSAGE + output)
class InputHandler {
    fun readInput(): String {
        println(PROMPT_INPUT_MESSAGE)
        return Console.readLine()
    }
}
