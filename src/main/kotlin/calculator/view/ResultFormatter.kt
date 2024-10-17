package calculator.view

import java.math.BigDecimal
import java.text.DecimalFormat

class ResultFormatter(
    private val result: BigDecimal
) {
    fun toNumberFormat(): String {
        if (isPositiveDecimal()) return DecimalFormat(positiveDecimalPattern()).format(result)
        return DecimalFormat("#,###").format(result)
    }

    private fun positiveDecimalPattern(): String {
        var ori = "#,###."
        repeat(countDecimalPlaces()) {
            ori += "#"
        }
        return ori
    }

    private fun countDecimalPlaces(): Int = "$result".split(".")[1].length

    private fun isPositiveDecimal(): Boolean = "$result".contains(".")
}