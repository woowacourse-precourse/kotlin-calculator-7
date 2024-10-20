package calculator.domain

import java.math.BigDecimal
import java.text.DecimalFormat

class SumCalculator(
    private val delimitedSplitResult: List<String>
) {
    fun calculateSum(): String = delimitedSplitResult.sumOf { it.toBigDecimal() }.toNumberFormat()

    private fun BigDecimal.toNumberFormat(): String {
        if (isPositiveDecimal(this)) return DecimalFormat(positiveDecimalPattern(this)).format(this)
        return DecimalFormat("#,###").format(this)
    }

    private fun positiveDecimalPattern(result: BigDecimal): String {
        val ori = StringBuilder("#,###.")
        ori.append(generateDecimalPlacesPattern(countDecimalPlaces(result)))
        return ori.toString()
    }

    private fun generateDecimalPlacesPattern(decimalPlaces: Int) = "#".repeat(decimalPlaces)

    private fun countDecimalPlaces(result: BigDecimal): Int = "$result".split(".")[1].length

    private fun isPositiveDecimal(result: BigDecimal): Boolean = "$result".contains(".")
}