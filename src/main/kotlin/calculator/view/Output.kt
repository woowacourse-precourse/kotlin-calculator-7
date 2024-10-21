package calculator.view

class Output {
    fun printCalculateResult(result: Int) {
        print("$RESULT_PREFIX$result")
    }

    companion object {
        private const val RESULT_PREFIX = "결과 : "
    }
}