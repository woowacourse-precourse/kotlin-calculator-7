package calculator.view

class OutputView {

    fun printResultMessage(result: Int) =
        println("$OUTPUT_RESULT_MESSAGE $result")

    companion object {
        private const val OUTPUT_RESULT_MESSAGE = "결과 :"
    }
}
