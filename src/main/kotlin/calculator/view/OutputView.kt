package calculator.view

class OutputView {
    fun printResult(result: Int) {
        println(OUTPUT_MESSAGE + result)
    }

    companion object {
        private const val OUTPUT_MESSAGE = "결과 : "
    }
}