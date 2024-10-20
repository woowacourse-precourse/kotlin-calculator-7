package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SplitNumberTest {
    private val calculator = Calculator()

    @Test
    fun `커스텀 구분자 문자열 파싱 테스트`() {
        calculator.separators.add(';')
        assertEquals(listOf("1", "2", "4"), calculator.customSeparatorSplit("//;\\n1;2,4"))
    }

    @Test
    fun `기본 구분자 문자열 파싱 테스트`() {
        assertEquals(listOf("1", "2", "5"), calculator.defaultSeparatorSplit("1,2:5"))
    }
}
