package calculator.view

class OutputView {
    fun printResult(result: Int) {
        print(OUTPUT_MSG.format(result))
    }

    companion object {
        const val OUTPUT_MSG = "결과 : %s"
    }
}