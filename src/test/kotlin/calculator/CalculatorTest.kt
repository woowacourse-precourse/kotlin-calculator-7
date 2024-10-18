package calculator

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.math.BigInteger

class CalculatorTest {

    @Nested
    @DisplayName("sum() 메서드")
    inner class Sum {
        private val calculator = Calculator()

        @Test
        fun `매개변수로 들어온 리스트의 총합을 반환한다`() {
            // given
            val input = listOf(BigInteger("10000"), BigInteger.TEN, BigInteger("1000000000"))
            val expected = BigInteger("1000010010")

            // when
            val actual = calculator.sum(input)

            // then
            Assertions.assertEquals(expected, actual)
        }

        @Test
        fun `10^18 보다 큰 숫자들의 합을 반환할 수 있다`() {
            // given
            val input = listOf(BigInteger("100000000000000000000000000"), BigInteger("10000000000000000000000"))
            val expected = BigInteger("100010000000000000000000000")

            // when
            val actual = calculator.sum(input)

            // then
            Assertions.assertEquals(expected, actual)
        }

    }
}