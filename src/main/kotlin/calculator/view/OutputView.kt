package calculator.view

class OutputView {

    fun printResultOfSum(sum: Int) = println(OUTPUT_SUM_RESULT.format(sum))

    companion object {
        const val OUTPUT_SUM_RESULT = "결과 : %d"
    }
}