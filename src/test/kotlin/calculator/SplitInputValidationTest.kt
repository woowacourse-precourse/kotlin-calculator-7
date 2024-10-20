package calculator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class SplitInputValidationTest {
    private val calculator = Calculator()

    @Test
    fun `파싱한 문자열 에러 테스트`() {
        assertThrows<IllegalArgumentException> {
            calculator.splitInputValidationCheck(listOf("-1", "3", "5", "7"))
        }
        assertThrows<IllegalArgumentException> {
            calculator.splitInputValidationCheck(listOf("1", "2", "3a"))
        }
    }
}
