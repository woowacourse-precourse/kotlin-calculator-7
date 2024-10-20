package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CustomSeparatorTest {
    private val calculator = Calculator()

    @Test
    fun `커스텀 구분자 유무 확인 테스트`() {
        assertEquals(true, calculator.customSeparatorCheck("//;\\n1;2;3"))
        assertEquals(false, calculator.customSeparatorCheck("1,2,3,4"))
    }

    @Test
    fun `커스텀 구분자 에러 발생 테스트`() {
        assertThrows<IllegalArgumentException> {
            calculator.customSeparatorCheck("//2\\n1,2,3")
        }
        assertThrows<IllegalArgumentException> {
            calculator.customSeparatorCheck("//;1,2,3")
        }
    }
}
