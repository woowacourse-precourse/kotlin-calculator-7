import calculator.Calculator
import calculator.DelimiterExtractor
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class CalculatorTest {

    private val delimiterExtractor = DelimiterExtractor() // DelimiterExtractor 객체
    private val calculator = Calculator(delimiterExtractor)

    @Test
    fun `빈 문자열 입력 시 0을 반환하는지 테스트`() {
        val input = ""

        val result = calculator.add(input)
        assertEquals(BigDecimal.ZERO, result)
    }

    @Test
    fun `커스텀 구분자를 사용`() {
        val input = "//;\\n1;2;3"

        val result = calculator.add(input)
        assertEquals(BigDecimal(6), result)
    }

    @Test
    fun `커스텀 구분자와 기본 구분자 동시 사용`() {
        val input = "//!\\n1!2:3,4"

        val result = calculator.add(input)
        assertEquals(BigDecimal(10), result)
    }

    @Test
    fun `특수 기호 사용`() {
        val input = "//.\\n1.2.3"

        val result = calculator.add(input)
        assertEquals(BigDecimal(6), result)
    }

    @Test
    fun `숫자가 음수인 경우 예외 발생`() {
        val input = "//;\\n1;2;-3"

        val exception = org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            calculator.add(input)
        }
        assertThat(exception.message).isEqualTo("양수를 입력해주세요.")
    }

    @Test
    fun `잘못된 형식의 숫자 입력 시 예외 발생`() {
        val input = "//;\\n1;a;3"

        val exception = org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            calculator.add(input)
        }
        assertThat(exception.message).isEqualTo("잘못된 형식으로 숫자 분류가 실패되었습니다.")
    }

    @Test
    fun `커스텀 구분자 여러 개 사용`() {
        val input = "//!@#\\n1!2@3#4"

        val result = calculator.add(input)
        assertEquals(BigDecimal(10), result)
    }

    @Test
    fun `실수 계산`() {
        val input = "1.2,2.4"

        val result = calculator.add(input)
        assertEquals(BigDecimal("3.6"), result)
    }

}


