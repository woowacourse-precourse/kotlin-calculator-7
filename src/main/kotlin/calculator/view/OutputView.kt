package calculator.view

class OutputView {

    fun printResult(result: Int) {
        println(RESULT_MESSAGE + result)
    }

    companion object {
        private const val RESULT_MESSAGE = "결과 : "
    }
}