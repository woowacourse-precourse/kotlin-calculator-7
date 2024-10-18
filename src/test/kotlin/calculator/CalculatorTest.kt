package calculator

import calculator.model.Calculator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CalculatorTest {

    @DisplayName("Calculator Test : 덧셈 결과 출력")
    @Test
    fun testCalculator() {
        val input = listOf(1, 2, 3)
        val expected = 6

        val result = Calculator(input).getResult()
        assertEquals(expected, result)
    }
}