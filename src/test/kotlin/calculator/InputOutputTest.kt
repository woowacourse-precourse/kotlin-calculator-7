package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InputOutputTest {
    private val calculator = Calculator()

    @Test
    fun `입력값 빈 칸 테스트`() {
        val result = calculator.calculate(listOf(""))
        assertEquals("결과 : 0", calculator.printOutput(result))
    }

    @Test
    fun `입력값 자료형 테스트`() {
        val result = calculator.calculate(listOf("2147483647", "1", "2"))
        assertEquals("결과 : 2147483650", calculator.printOutput(result))
    }

    @Test
    fun `출력값 테스트`() {
        assertEquals(10, calculator.calculate(listOf("1", "2", "3", "4")))
    }
}
