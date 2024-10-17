package calculator.view

class OutputView {
    fun inputRequest() = println(REQUEST_INPUT_STRING_FOR_ADDITION)

    fun printSumResult(result: String) = println("$RESULT_LABEL$result")

    companion object {
        const val REQUEST_INPUT_STRING_FOR_ADDITION = "덧셈할 문자열을 입력해 주세요."
        const val RESULT_LABEL = "결과 : "
    }
}
