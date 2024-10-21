package calculator

import java.math.BigDecimal

class Calculator {
    fun sum(numbers: List<BigDecimal>) = numbers.sumOf { it }
}