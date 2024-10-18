package calculator

import calculator.model.Delimiter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class DelimiterTest {

    @DisplayName("Delimiter Test : 커스텀 구분자 추출")
    @Test
    fun findCustomDelimiterTest() {
        val input = "//$\\n1,2$,3"
        val expected = listOf(",", ":", "$")

        val delimiter = Delimiter(input)

        assertEquals(expected, delimiter.getDelimiters())
    }

    @DisplayName("Delimiter Test : 여러 커스텀 구분자 추출")
    @Test
    fun findMultipleCustomDelimitersTest() {
        val input = "//;\\n//|\\n1,2;3|4"
        val expected = listOf(",", ":", ";", "|")

        val delimiter = Delimiter(input)

        assertEquals(expected, delimiter.getDelimiters())
    }

    @DisplayName("Delimiter Test : 커스텀 구분자 유효성 검사 실패 (Length)")
    @Test
    fun validateCustomDelimiterLengthExceptionTest() {
        val input = "//$!\\n1,2$,3"

        val exception = assertThrows<IllegalArgumentException> { Delimiter(input) }

        assert(exception.message == Delimiter.INVALID_SIZE_MESSAGE)
    }

    @DisplayName("Delimiter Test : 커스텀 구분자 유효성 검사 실패 (Char)")
    @Test
    fun validateCustomDelimiterCharExceptionTest() {
        val input = "//3\\n1,2,3"

        val exception = assertThrows<IllegalArgumentException> { Delimiter(input) }

        assert(exception.message == Delimiter.INVALID_CHARACTER_MESSAGE)
    }
}