package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CalculatorTest {

    lateinit var calculator: Calculator

    @BeforeEach
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun `더하기 예외 테스트`() {
        val result = calculator.sum(listOf("1", "8", "12").map { it.toBigDecimal() })
        val expect = "21".toBigDecimal()
        assertEquals(expect, result)
    }

    @Test
    fun `더하기(마이너스 포함) 예외 테스트`() {
        val result = calculator.sum(listOf("1", "8", "-12").map { it.toBigDecimal() })
        val expect = "-3".toBigDecimal()
        assertEquals(expect, result)
    }

    @Test
    fun `더하기(소수점 포함) 예외 테스트`() {
        val result = calculator.sum(listOf("1", "8", "-9.5").map { it.toBigDecimal() })
        val expect = "-0.5".toBigDecimal()
        assertEquals(expect, result)
    }

    @Test
    fun `더하기(매우 큰수 포함) 예외 테스트`() {
        val result = calculator.sum(
            listOf(
                "1",
                "8",
                "1328391241341341343123123512324872837282312324241.1234522"
            ).map { it.toBigDecimal() })
        val expect = "1328391241341341343123123512324872837282312324250.1234522".toBigDecimal()
        assertEquals(expect, result)
    }
}