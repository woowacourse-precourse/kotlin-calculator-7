package calculator.domain

import java.math.BigDecimal

class SumCalculator(
    private val delimitedSplitResult: List<String>
) {
    fun calculateTotal(): BigDecimal = delimitedSplitResult.sumOf { it.toBigDecimal() }
}