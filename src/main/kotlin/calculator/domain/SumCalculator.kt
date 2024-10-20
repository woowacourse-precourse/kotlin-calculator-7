package calculator.domain

import java.math.BigDecimal
import java.text.DecimalFormat

class SumCalculator(
    private val delimitedSplitResult: List<String>
) {
    fun calculateTotal(): String = delimitedSplitResult.sumOf { it.toBigDecimal() }.toNumberFormat()

    private fun BigDecimal.toNumberFormat(): String {
        if (isPositiveDecimal(this)) return DecimalFormat(positiveDecimalPattern(this)).format(this)
        return DecimalFormat("#,###").format(this)
    }

    private fun positiveDecimalPattern(result: BigDecimal): String {
        val ori = StringBuilder("#,###.")
        repeat(countDecimalPlaces(result)) {
            ori.append("#")
        }
        return ori.toString()
    }

    private fun countDecimalPlaces(result: BigDecimal): Int = "$result".split(".")[1].length

    private fun isPositiveDecimal(result: BigDecimal): Boolean = "$result".contains(".")
}