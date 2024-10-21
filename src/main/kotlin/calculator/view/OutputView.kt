package calculator.view

object OutputView {
    private const val RESULT_MESSAGE = "결과 : "

    fun printResult(result: Int) {
        print(RESULT_MESSAGE + result)
    }
}
