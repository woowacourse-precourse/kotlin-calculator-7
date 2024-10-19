package calculator.view

import calculator.constants.OUTPUT_SUM_RESULT

class OutputView {

    fun printResultOfSum(sum: Int) = println(OUTPUT_SUM_RESULT.format(sum))
}